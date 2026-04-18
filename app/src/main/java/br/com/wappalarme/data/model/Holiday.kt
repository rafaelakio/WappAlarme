package br.com.wappalarme.data.model

/**
 * Modelo de feriado retornado pela API BrasilAPI.
 */
data class Holiday(
    val date: String,       // formato: yyyy-MM-dd
    val localName: String,  // nome em português
    val name: String,       // nome em inglês
    val countryCode: String,
    val fixed: Boolean,
    val global: Boolean,
    val counties: List<String>?,
    val launchYear: Int?,
    val types: List<String>
)

/**
 * Modelo simplificado para uso interno.
 */
data class HolidayInfo(
    val date: String,
    val name: String,
    val type: HolidayType
)

enum class HolidayType {
    NATIONAL,   // Feriado nacional
    STATE,      // Feriado estadual
    MUNICIPAL   // Feriado municipal
}
