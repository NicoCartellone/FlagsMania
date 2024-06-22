package ar.edu.unlam.mobile.scaffolding.ui.screens.gameAdvancedResult

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
sealed interface GameAdvancedResultUIState {
    data class Success(val gameResult: GameResult) : GameAdvancedResultUIState

    data object Loading : GameAdvancedResultUIState

    data class Error(val message: String) : GameAdvancedResultUIState
}

data class GameAdvancedResultScreenUIState(
    val gameAdvancedResultState: GameAdvancedResultUIState,
)

@HiltViewModel
class GameAdvancedResultViewModel
    @Inject
    constructor(private val gameResultUseCase: GameResultUseCase) : ViewModel() {
        private val _uiState =
            MutableStateFlow(
                GameAdvancedResultScreenUIState(
                    GameAdvancedResultUIState.Loading,
                ),
            )

        val uiState: StateFlow<GameAdvancedResultScreenUIState> = _uiState.asStateFlow()

        init {
            fetchGameResults()
        }

        private fun fetchGameResults() {
            viewModelScope.launch {
                delay(500)
                gameResultUseCase.getFirstGameResult().collect { gameResult ->
                    _uiState.value =
                        _uiState.value.copy(
                            gameAdvancedResultState = GameAdvancedResultUIState.Success(gameResult),
                        )
                }
            }
        }
    }
