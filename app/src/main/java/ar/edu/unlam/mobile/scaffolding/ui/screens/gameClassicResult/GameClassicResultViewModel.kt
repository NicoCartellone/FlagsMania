package ar.edu.unlam.mobile.scaffolding.ui.screens.gameClassicResult

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface GameClassicResultUIState {
    data class Success(val gameResult: GameResult) : GameClassicResultUIState

    data object Loading : GameClassicResultUIState

    data class Error(val message: String) : GameClassicResultUIState
}

data class GameClassicResultScreenUIState(
    val gameClassicResultState: GameClassicResultUIState,
)

@HiltViewModel
class GameClassicResultViewModel
    @Inject
    constructor(private val gameResultUseCase: GameResultUseCase) : ViewModel() {
        private val _uiState =
            MutableStateFlow(
                GameClassicResultScreenUIState(
                    GameClassicResultUIState.Loading,
                ),
            )

        val uiState: StateFlow<GameClassicResultScreenUIState> = _uiState.asStateFlow()

        init {
            fetchGameResults()
        }

        private fun fetchGameResults() {
            viewModelScope.launch {
                delay(500)
                gameResultUseCase.getFirstGameResult().collect { gameResult ->
                    _uiState.value =
                        _uiState.value.copy(
                            gameClassicResultState = GameClassicResultUIState.Success(gameResult),
                        )
                }
            }
        }
    }
