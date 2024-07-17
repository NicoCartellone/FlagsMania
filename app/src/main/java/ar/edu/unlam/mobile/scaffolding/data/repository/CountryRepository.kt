package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.models.CountryResponse
import ar.edu.unlam.mobile.scaffolding.data.network.CountryApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// CREAR REPOSITORY
class CountryRepository
    @Inject
    constructor(private val apiService: CountryApiService) {
        fun getAllCountries(): Flow<List<CountryResponse>> =
            flow {
                val countries = apiService.getAllCountries()
                emit(countries)
            }
    }
