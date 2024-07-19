package ar.edu.unlam.mobile.scaffolding.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameAdvancedRulesScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameClassicRulesScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.HomeScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.gameAdvanced.GameAdvancedScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.gameAdvancedResult.GameAdvancedResultScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.gameClassic.GameClassicScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.gameClassicResult.GameClassicResultScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.localRanking.LocalRankingScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.onlineRanking.OnlineRankingScreen

@Composable
fun NavigationComponent() {
    val controller = rememberNavController()

    Scaffold { paddingValue ->

        NavHost(navController = controller, startDestination = NavHostRouterPaths.Home.route) {
            composable(NavHostRouterPaths.Home.route) {
                HomeScreen(modifier = Modifier.padding(paddingValue), controller)
            }
            composable(NavHostRouterPaths.GameClassic.route) {
                GameClassicScreen(controller)
            }
            composable(NavHostRouterPaths.GameClassicResult.route) {
                GameClassicResultScreen(controller)
            }
            composable(NavHostRouterPaths.GameAdvancedResult.route) {
                GameAdvancedResultScreen(controller)
            }
            composable(NavHostRouterPaths.GameAdvanced.route) {
                GameAdvancedScreen(controller)
            }
            composable(NavHostRouterPaths.GameClassicRules.route) {
                GameClassicRulesScreen(controller)
            }
            composable(NavHostRouterPaths.GameAdvancedRules.route) {
                GameAdvancedRulesScreen(controller)
            }
            composable(NavHostRouterPaths.LocalRanking.route) {
                LocalRankingScreen(controller)
            }
            composable(NavHostRouterPaths.OnlineRanking.route) {
                OnlineRankingScreen(controller)
            }
        }
    }
}
