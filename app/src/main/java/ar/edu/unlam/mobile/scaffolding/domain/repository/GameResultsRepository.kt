package ar.edu.unlam.mobile.scaffolding.domain.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import kotlinx.coroutines.flow.Flow

interface GameResultsRepository {
    suspend fun saveGameResult(gameResult: GameResult)

    fun getGameResults(): Flow<List<GameResult>>

    suspend fun getFirstGameResult(): Flow<GameResult>
}
