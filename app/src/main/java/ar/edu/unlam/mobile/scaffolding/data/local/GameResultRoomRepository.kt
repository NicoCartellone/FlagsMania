package ar.edu.unlam.mobile.scaffolding.data.local

import ar.edu.unlam.mobile.scaffolding.data.repository.GameResultLocalRepository
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameResultRoomRepository
    @Inject
    constructor(
        private val appDb: AppDatabase,
    ) : GameResultLocalRepository {
        private val gameResultDao = appDb.gameResultDao()

        override suspend fun saveGameResult(gameResult: GameResult) {
            gameResultDao.insertGameResult(gameResult.asEntity())
        }

        override fun getGameResults(): Flow<List<GameResult>> {
            return gameResultDao.getAllGameResults().map {
                it.map { gameResultEntity ->
                    gameResultEntity.asModel()
                }
            }
        }

        override fun getFirstGameResult(): Flow<GameResult> {
            return gameResultDao.getFirstGameResult().map {
                it.asModel()
            }
        }
    }
