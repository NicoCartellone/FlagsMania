package ar.edu.unlam.mobile.scaffolding.ui.screens.localRanking

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface PointsHistoryListUIState {
    data class Success(
        val historyPointsList: List<GameResult>,
    ) : PointsHistoryListUIState

    data object Loading : PointsHistoryListUIState

    data class Error(
        val message: String,
    ) : PointsHistoryListUIState
}

data class PointsHistoryUIState(
    val pointsHistoryState: PointsHistoryListUIState,
)

@HiltViewModel
class PointsHistoryViewModel
    @Inject
    constructor(
        private val gameResultUseCase: GameResultUseCase,
    ) : ViewModel() {
        private val _uiState =
            MutableStateFlow(
                PointsHistoryUIState(
                    PointsHistoryListUIState.Loading,
                ),
            )

        val uiState = _uiState.asStateFlow()

        init {
            viewModelScope.launch {
                delay(1000)
                gameResultUseCase.getGameResults().collect {
                    _uiState.value =
                        _uiState.value.copy(pointsHistoryState = PointsHistoryListUIState.Success(it))
                }
            }
        }
    }
