package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.domain.repository.GameResultsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameResultDefaultRepository
    @Inject
    constructor(private val local: GameResultLocalRepository) : GameResultsRepository {
        override suspend fun saveGameResult(gameResult: GameResult) {
            local.saveGameResult(gameResult)
        }

        override fun getGameResults(): Flow<List<GameResult>> {
            return local.getGameResults()
        }

        override fun getFirstGameResult(): Flow<GameResult> {
            return local.getFirstGameResult()
        }
    }
