package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameResultDao {
    @Insert
    suspend fun insertGameResult(gameResult: GameResultEntity)

    @Query("SELECT * FROM game_results ORDER BY timestamp DESC")
    fun getAllGameResults(): Flow<List<GameResultEntity>>

    @Query("SELECT * FROM game_results ORDER BY timestamp DESC LIMIT 1")
    fun getFirstGameResult(): Flow<GameResultEntity>
}
