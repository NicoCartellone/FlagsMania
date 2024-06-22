package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.data.models.CountryResponse
import org.junit.Test

class CountryResponseTest {
    @Test
    fun testConvertToOption() {
        val countryResponse =
            CountryResponse(
                "Argentina",
                arrayListOf("Buenos Aires"),
                "America",
                44938712,
                "https://restcountries.com/data/arg.svg",
            )

        val toCountryOption = countryResponse.toCountryOption()
        println(toCountryOption)
    }
}
