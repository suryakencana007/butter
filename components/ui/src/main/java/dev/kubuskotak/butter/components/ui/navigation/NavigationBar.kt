package dev.kubuskotak.butter.components.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


interface TopLevelRoute {
    val route: String

    @get:StringRes
    val title: Int
    val icon: ImageVector
    val tag: String
}

class NavigationActions(private val navController: NavHostController) {

    fun navigateTo(screen: TopLevelRoute) {
        navController.navigate(screen.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

@Composable
fun NavigationBottomBar(
    selectedRoute: String,
    listTopLevelRoute: List<TopLevelRoute>,
    navigateToTopLevelRoute: (TopLevelRoute) -> Unit
) {
    NavigationBar(modifier = Modifier.fillMaxWidth(), tonalElevation = 0.dp) {
        listTopLevelRoute.forEach { screen ->
            NavigationBarItem(
                modifier = Modifier.semantics { testTag = screen.tag },
                label = { Text(stringResource(screen.title)) },
                selected = selectedRoute == screen.route,
                onClick = { navigateToTopLevelRoute(screen) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = stringResource(
                            id = screen.title
                        )
                    )
                },
            )
        }
    }
}