package dev.kubuskotak.butter.ui

data class UIState(
    val isInitialized: Boolean = false,
    val defaultHomeScreen: String? = null
) {
    companion object {
        val empty = UIState(
            isInitialized = false,
            defaultHomeScreen = Screen.Home.route
        )
    }
}