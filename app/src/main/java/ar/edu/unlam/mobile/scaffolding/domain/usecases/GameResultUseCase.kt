package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import kotlinx.coroutines.flow.Flow

interface GameResultUseCase {
    suspend fun saveGameResult(gameResult: GameResult)

    fun getGameResults(): Flow<List<GameResult>>

    fun getFirstGameResult(): Flow<GameResult>
}
