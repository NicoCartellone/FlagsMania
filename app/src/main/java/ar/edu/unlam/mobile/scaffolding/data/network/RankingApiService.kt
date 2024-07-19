package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.data.models.Ranking
import retrofit2.http.GET
import retrofit2.http.Query

interface RankingApiService {
    @GET("macros/s/AKfycbxU8IcIQPLAh1fF-tctZl0jth9hmA2USDHi9qeM7yIyDJAtDgl3Vv1vgAFIswF_AjKEug/exec")
    suspend fun getRanking(
        @Query("spreadsheetId") spreadsheetId: String,
        @Query("sheet") sheet: String,
    ): Ranking
}
