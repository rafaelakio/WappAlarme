package br.com.wappalarme.ui.message

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.wappalarme.databinding.FragmentNewMessageBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class NewMessageFragment : Fragment() {

    private var _binding: FragmentNewMessageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScheduledMessageViewModel by viewModels()

    private var selectedContactName = ""
    private var selectedPhoneNumber = ""
    private var selectedDateMillis = 0L
    private var selectedHour = 8
    private var selectedMinute = 0

    // Launcher para selecionar contato
    private val contactPickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri -> processContactUri(uri) }
        }
    }

    // Launcher para permissão de contatos
    private val contactPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) openContactPicker()
        else Snackbar.make(binding.root, "Permissão de contatos necessária", Snackbar.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupContactButton()
        setupDateButton()
        setupTimeButton()
        setupSendButton()
        observeViewModel()
    }

    private fun setupContactButton() {
        binding.btnSelectContact.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.READ_CONTACTS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openContactPicker()
            } else {
                contactPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
            }
        }
    }

    private fun openContactPicker() {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        contactPickerLauncher.launch(intent)
    }

    private fun processContactUri(uri: Uri) {
        val cursor: Cursor? = requireContext().contentResolver.query(
            uri,
            arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
            ),
            null, null, null
        )

        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                selectedContactName = it.getString(nameIndex) ?: ""
                selectedPhoneNumber = it.getString(numberIndex)?.replace(Regex("[^0-9+]"), "") ?: ""

                binding.tvSelectedContact.text = selectedContactName
                binding.tvSelectedPhone.text = selectedPhoneNumber
                binding.tvSelectedContact.visibility = View.VISIBLE
                binding.tvSelectedPhone.visibility = View.VISIBLE
            }
        }
    }

    private fun setupDateButton() {
        binding.btnSelectDate.setOnClickListener {
            val constraints = CalendarConstraints.Builder()
                .setValidator(DateValidatorPointForward.now())
                .build()

            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecione a data")
                .setCalendarConstraints(constraints)
                .build()

            datePicker.addOnPositiveButtonClickListener { millis ->
                selectedDateMillis = millis
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
                binding.tvSelectedDate.text = sdf.format(Date(millis))
                binding.tvSelectedDate.visibility = View.VISIBLE
            }

            datePicker.show(parentFragmentManager, "date_picker")
        }
    }

    private fun setupTimeButton() {
        binding.btnSelectTime.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(selectedHour)
                .setMinute(selectedMinute)
                .setTitleText("Selecione o horário")
                .build()

            timePicker.addOnPositiveButtonClickListener {
                selectedHour = timePicker.hour
                selectedMinute = timePicker.minute
                binding.tvSelectedTime.text = String.format("%02d:%02d", selectedHour, selectedMinute)
                binding.tvSelectedTime.visibility = View.VISIBLE
            }

            timePicker.show(parentFragmentManager, "time_picker")
        }
    }

    private fun setupSendButton() {
        binding.btnScheduleMessage.setOnClickListener {
            if (selectedDateMillis == 0L) {
                Snackbar.make(binding.root, "Selecione uma data", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Combina data selecionada com hora selecionada
            val calendar = Calendar.getInstance().apply {
                timeInMillis = selectedDateMillis
                set(Calendar.HOUR_OF_DAY, selectedHour)
                set(Calendar.MINUTE, selectedMinute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }

            viewModel.scheduleMessage(
                contactName = selectedContactName,
                phoneNumber = selectedPhoneNumber,
                message = binding.etMessage.text?.toString() ?: "",
                scheduledAt = calendar.timeInMillis
            )
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    is MessageUiState.Idle -> Unit
                    is MessageUiState.Loading -> binding.btnScheduleMessage.isEnabled = false
                    is MessageUiState.Success -> {
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                        viewModel.resetState()
                        findNavController().navigateUp()
                    }
                    is MessageUiState.Error -> {
                        binding.btnScheduleMessage.isEnabled = true
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                        viewModel.resetState()
                    }
                }
            }
        }
    }

    // Extensão para lifecycleScope.launchWhenStarted
    private fun androidx.lifecycle.LifecycleOwner.lifecycleScope() =
        androidx.lifecycle.lifecycleScope

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
