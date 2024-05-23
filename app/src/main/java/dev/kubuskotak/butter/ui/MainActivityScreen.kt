package dev.kubuskotak.butter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.kubuskotak.butter.components.ui.navigation.NavigationActions
import dev.kubuskotak.butter.components.ui.navigation.NavigationBottomBar

@Composable
fun MainActivityScreen(viewModel: MainActivityViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTag = MainActivityTags.ROOT }
    ) {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val state by viewModel.state.collectAsState()
        val navHostController = rememberNavController()
        val navigationActions = remember(navHostController) {
            NavigationActions(navHostController)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val selectedRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route
                if (Screen.showsBottomNav(navBackStackEntry?.destination?.route)) {
                    NavigationBottomBar(
                        selectedRoute = selectedRoute,
                        listTopLevelRoute = bottomNavRoutes,
                        navigateToTopLevelRoute = navigationActions::navigateTo
                    )
                }
            }
        ) { paddingValues ->
            if (state.isInitialized) {
            NavHost(
                navController = navHostController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                addHomeRoutes(navHostController)
            }
            }
        }
    }
}

object MainActivityTags {
    const val ROOT = "MainActivityRoot"
    const val HOME = "MainActivityHome"
}