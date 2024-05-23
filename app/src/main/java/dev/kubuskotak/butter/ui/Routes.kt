package dev.kubuskotak.butter.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.kubuskotak.butter.components.ui.navigation.TopLevelRoute

/**
 * List of routes which can be accessed via the bottom navigation.
 */
val bottomNavRoutes = listOf<TopLevelRoute>(
    Screen.Home
)

fun NavGraphBuilder.addHomeRoutes(navController: NavHostController) {
    composable(
        route = Screen.Home.route
    ) {
        HomeView()
    }
}

@Composable
fun HomeView() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "hello world")
    }
}