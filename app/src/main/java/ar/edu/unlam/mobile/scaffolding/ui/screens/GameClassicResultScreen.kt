package ar.edu.unlam.mobile.scaffolding.ui.screens

import android.util.Log
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
import ar.edu.unlam.mobile.scaffolding.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CustomButton
import ar.edu.unlam.mobile.scaffolding.ui.components.GradientComponent
import ar.edu.unlam.mobile.scaffolding.ui.components.ScoreCard

@Composable
fun GameClassicResultScreen(
    controller: NavHostController,
    gameResultViewModel: GameClassicResultViewModel = hiltViewModel(),
) {
    val gameResults by gameResultViewModel.gameResults.collectAsState()
    val firstGameResult = gameResultViewModel.firstGameResult
    val gameType = controller.currentBackStackEntry?.arguments?.getString("gameType")
    Log.d("room", "Todos los resultados de la db: $gameResults")
    Log.d("GameClassicResultScreen", "firstGameResult: $firstGameResult")

    BackHandler {
        controller.navigate(NavHostRouterPaths.HOME.route)
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
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
                    counter = firstGameResult?.points ?: 0,
                    correctAnswers = firstGameResult?.correctAnswers ?: 0,
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
                when (gameType) {
                    "classic" -> {
                        CustomButton(
                            text = "Volver a jugar",
                            onClick = { controller.navigate(NavHostRouterPaths.GAME_CLASSIC.route) },
                        )
                    }
                    "advance" -> {
                        CustomButton(
                            text = "Volver a jugar",
                            onClick = { controller.navigate(NavHostRouterPaths.GAME_ADVANCED.route) },
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(
                    text = "Menu principal",
                    onClick = { controller.navigate(NavHostRouterPaths.HOME.route) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameClassicResultScreenPreview() {
// Necesitamos un controlador de navegación falso para la vista previa
    val navController = rememberNavController()
    GameClassicResultScreen(controller = navController)
}
