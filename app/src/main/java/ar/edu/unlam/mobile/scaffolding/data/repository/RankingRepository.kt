package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.models.Ranking
import ar.edu.unlam.mobile.scaffolding.data.network.RankingApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RankingRepository
    @Inject
    constructor(
        private val apiServiceSheet: RankingApiService,
    ) {
        fun getRanking(
            spreadsheetId: String,
            sheet: String,
        ): Flow<Ranking> =
            flow {
                val ranking = apiServiceSheet.getRanking(spreadsheetId, sheet)
                emit(ranking)
            }
    }
