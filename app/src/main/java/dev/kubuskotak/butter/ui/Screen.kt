package dev.kubuskotak.butter.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.navigation.NamedNavArgument
import dev.kubuskotak.butter.components.ui.navigation.TopLevelRoute
import dev.kubuskotak.butter.components.ui.resources.StringResource

/**
 * List of screens for [MainActivity]
 */
sealed class Screen {
    abstract val route: String
    open val args: List<NamedNavArgument> = emptyList()

    companion object {
        fun showsBottomNav(route: String?): Boolean {
            return true
        }
    }

    object Home : Screen(), TopLevelRoute {
        override val route = "home"

        override val title = StringResource.nav_home
        override val icon = Icons.Default.Home
        override val tag = MainActivityTags.HOME
    }
}