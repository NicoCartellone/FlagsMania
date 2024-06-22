package ar.edu.unlam.mobile.scaffolding.data.models

import ar.edu.unlam.mobile.scaffolding.domain.models.CountryOption

// CLASE DATA PARA LA RESPUESTA DE LA API
data class CountryResponse(
    val name: String,
    val capital: List<String>?,
    val region: String,
    val population: Int,
    val flag: String,
) {
    fun toCountryOption(): CountryOption {
        return CountryOption(
            country = name,
            flag = flag,
            city = capital?.getOrNull(0) ?: "",
        )
    }
}
