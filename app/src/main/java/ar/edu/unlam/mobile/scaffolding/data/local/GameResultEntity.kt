package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult

@Entity(tableName = "game_results")
data class GameResultEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val points: Int,
    val correctAnswers: Int,
    val gameType: String,
    val gameDate: String,
    val timestamp: Long = System.currentTimeMillis(),
)

fun GameResultEntity.asModel() =
    GameResult(
        id = id.toUInt(),
        points = points,
        correctAnswers = correctAnswers,
        gameType = gameType,
        gameDate = gameDate,
        timestamp = timestamp,
    )

fun GameResult.asEntity() =
    GameResultEntity(
        points = points,
        correctAnswers = correctAnswers,
        gameType = gameType,
        gameDate = gameDate,
        timestamp = timestamp,
    )
