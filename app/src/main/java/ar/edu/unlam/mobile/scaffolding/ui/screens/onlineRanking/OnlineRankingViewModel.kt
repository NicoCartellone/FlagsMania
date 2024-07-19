package ar.edu.unlam.mobile.scaffolding.ui.screens.onlineRanking

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.data.models.Ranking
import ar.edu.unlam.mobile.scaffolding.data.repository.RankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface RankingResponseUIState {
    data class Success(
        val ranking: Ranking,
    ) : RankingResponseUIState

    data object Loading : RankingResponseUIState

    data class Error(
        val message: String,
    ) : RankingResponseUIState
}

data class RankingUIState(
    val rankingState: RankingResponseUIState,
)

@HiltViewModel
class RankingViewModel
    @Inject
    constructor(
        private val rankingRepository: RankingRepository,
    ) : ViewModel() {
        private val _uiState =
            MutableStateFlow(
                RankingUIState(
                    RankingResponseUIState.Loading,
                ),
            )
        val uiState = _uiState.asStateFlow()

        init {
            fetchOnlineRanking()
        }

        private fun fetchOnlineRanking() {
            viewModelScope.launch {
                try {
                    rankingRepository
                        .getRanking(
                            "10dN1izDULtn-G02p1JhFwwsiKI4WMSRaFyw9apzBuno",
                            "jugadores",
                        ).collect { ranking ->
                            _uiState.value =
                                _uiState.value.copy(
                                    rankingState = RankingResponseUIState.Success(ranking),
                                )
                        }
                } catch (e: Exception) {
                    _uiState.value =
                        _uiState.value.copy(rankingState = RankingResponseUIState.Error("Error obteniendo los datos del ranking"))
                }
            }
        }
    }
