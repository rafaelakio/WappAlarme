package br.com.wappalarme.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.wappalarme.R
import br.com.wappalarme.databinding.FragmentScheduledMessageBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ScheduledMessageFragment : Fragment() {

    private var _binding: FragmentScheduledMessageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScheduledMessageViewModel by viewModels()
    private lateinit var adapter: ScheduledMessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduledMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupFab()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = ScheduledMessageAdapter(
            onCancel = { message ->
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Cancelar mensagem")
                    .setMessage("Deseja cancelar a mensagem para ${message.contactName}?")
                    .setPositiveButton("Cancelar mensagem") { _, _ ->
                        viewModel.cancelMessage(message.id)
                    }
                    .setNegativeButton("Voltar", null)
                    .show()
            },
            onDelete = { message ->
                viewModel.deleteMessage(message)
            }
        )

        binding.recyclerMessages.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ScheduledMessageFragment.adapter
        }
    }

    private fun setupFab() {
        binding.fabAddMessage.setOnClickListener {
            findNavController().navigate(R.id.action_scheduledMessageFragment_to_newMessageFragment)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.allMessages.collect { messages ->
                        adapter.submitList(messages)
                        binding.tvEmptyState.visibility =
                            if (messages.isEmpty()) View.VISIBLE else View.GONE
                    }
                }

                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is MessageUiState.Idle -> Unit
                            is MessageUiState.Loading -> Unit
                            is MessageUiState.Success -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                                viewModel.resetState()
                            }
                            is MessageUiState.Error -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG)
                                    .setBackgroundTint(requireContext().getColor(R.color.error_color))
                                    .show()
                                viewModel.resetState()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
