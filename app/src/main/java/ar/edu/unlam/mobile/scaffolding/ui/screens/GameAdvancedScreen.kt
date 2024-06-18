package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CardCountryGame
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.components.QuestionFlagsOptions

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameAdvancedScreen(
    controller: NavHostController,
    viewModel: GameClassicViewModel = hiltViewModel(),
) {
    val uiState: GameClassicUIState by viewModel.uiState.collectAsState()

    fun goToResult(controller: NavHostController) {
        controller.navigate("GameResult/advance")
    }

    viewModel.onCounterFinish = {
        goToResult(controller)
    }

    when (uiState) {
        is GameClassicUIState.Success -> {
            Column {
                Box {
                    GradientComponent(250)

                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Spacer(modifier = Modifier.padding(24.dp))
                        Box(
                            modifier =
                                Modifier
                                    .align(Alignment.CenterHorizontally),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_white),
                                contentDescription = "Logo",
                            )
                        }

                        Spacer(modifier = Modifier.padding(24.dp))

                        CardCountryGame(
                            pts = viewModel.pts,
                            actualCard = viewModel.actualCard,
                            viewModel = viewModel,
                            Modifier,
                        )
                    }
                }

                FlowRow(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    QuestionFlagsOptions(
                        viewModel.currentQuestion?.options,
                        viewModel.showAnswer,
                        viewModel.selectedCountry,
                        onClick = {
                            if (viewModel.actualCard == 10) {
                                goToResult(controller)
                            }
                            viewModel.nextFlagQuestion(it)
                        },
                    )
                }
            }
        }

        is GameClassicUIState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 64.dp),
                        alignment = Alignment.Center,
                    )
                    CircularProgressIndicator(color = Color(0xFFC4007A))
                }
            }
        }

        is GameClassicUIState.Error -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = (uiState as GameClassicUIState.Error).message)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedGameScreenPreview() {
    val controller = rememberNavController()
    GameAdvancedScreen(controller)
}
