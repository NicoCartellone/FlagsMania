package ar.edu.unlam.mobile.scaffolding.domain.models

data class GameResult(
    val id: UInt?,
    val points: Int,
    val correctAnswers: Int,
    val gameType: String,
    val gameDate: String,
    val timestamp: Long = System.currentTimeMillis(),
)
