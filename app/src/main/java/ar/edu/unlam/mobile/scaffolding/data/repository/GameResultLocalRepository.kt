package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import kotlinx.coroutines.flow.Flow

interface GameResultLocalRepository {
    suspend fun saveGameResult(gameResult: GameResult)

    fun getGameResults(): Flow<List<GameResult>>

    fun getFirstGameResult(): Flow<GameResult>
}
