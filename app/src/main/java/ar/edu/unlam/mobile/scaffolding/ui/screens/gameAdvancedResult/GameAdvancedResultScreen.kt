package ar.edu.unlam.mobile.scaffolding.ui.screens.gameAdvancedResult

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CustomButton
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.components.ScoreCard
import ar.edu.unlam.mobile.scaffolding.ui.navigation.NavHostRouterPaths

@Composable
fun GameAdvancedResultScreen(
    controller: NavHostController,
    viewModel: GameAdvancedResultViewModel = hiltViewModel(),
) {
    val uiState: GameAdvancedResultScreenUIState by viewModel.uiState.collectAsState()

    BackHandler {
        controller.navigate(NavHostRouterPaths.Home.route)
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        when (val gameAdvancedResultState = uiState.gameAdvancedResultState) {
            is GameAdvancedResultUIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(color = Color(0xFFC4007A))
                }
            }
            is GameAdvancedResultUIState.Success -> {
                Box {
                    GradientComponent(400)

                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Spacer(modifier = Modifier.padding(50.dp))
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

                        Spacer(modifier = Modifier.padding(15.dp))
                        ScoreCard(
                            counter = gameAdvancedResultState.gameResult.points,
                            correctAnswers = gameAdvancedResultState.gameResult.correctAnswers,
                        )
                    }
                }

                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CustomButton(
                            text = "Volver a jugar",
                            onClick = { controller.navigate(NavHostRouterPaths.GameAdvanced.route) },
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(
                            text = "Menu principal",
                            onClick = { controller.navigate(NavHostRouterPaths.Home.route) },
                        )
                    }
                }
            }
            is GameAdvancedResultUIState.Error -> {
                // Error
            }
        }
    }
}
