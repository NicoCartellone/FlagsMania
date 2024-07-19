package ar.edu.unlam.mobile.scaffolding.ui.navigation

sealed class NavHostRouterPaths(
    val route: String,
) {
    object Home : NavHostRouterPaths("home")

    object GameClassic : NavHostRouterPaths("GameClassic")

    object GameAdvanced : NavHostRouterPaths("GameAdvanced")

    object GameClassicResult : NavHostRouterPaths("GameClassicResult")

    object GameAdvancedResult : NavHostRouterPaths("GameAdvancedResult")

    object GameClassicRules : NavHostRouterPaths("GameClassicRules")

    object GameAdvancedRules : NavHostRouterPaths("GameAdvancedRules")

    object LocalRanking : NavHostRouterPaths("LocalRanking")

    object OnlineRanking : NavHostRouterPaths("OnlineRanking")
}
