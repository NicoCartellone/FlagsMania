package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.data.models.CountryResponse
import retrofit2.http.GET

// DEFINIR LA INTERFACE DE LA API
interface CountryApiService {
    @GET("api/countries")
    suspend fun getAllCountries(): List<CountryResponse>
}
