package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.domain.repository.GameResultsRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameResultUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameResultService
    @Inject
    constructor(private val gameResultRepository: GameResultsRepository) : GameResultUseCase {
        override suspend fun saveGameResult(gameResult: GameResult) {
            gameResultRepository.saveGameResult(gameResult)
        }

        override suspend fun getGameResults(): Flow<List<GameResult>> {
            return gameResultRepository.getGameResults()
        }

        override suspend fun getFirstGameResult(): Flow<GameResult> {
            return gameResultRepository.getFirstGameResult()
        }
    }
