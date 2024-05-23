package dev.kubuskotak.butter.ui

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kubuskotak.butter.components.ui.viewmodel.BaseViewModel
import dev.kubuskotak.butter.components.ui.viewmodel.ViewModelStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : BaseViewModel() {
    internal val uiState: ViewModelStateFlow<MainUIState> = viewModelStateFlow(MainUIState.Loading)
    internal val state: ViewModelStateFlow<UIState> = viewModelStateFlow(UIState.empty)

    init {
        state.value = UIState(
            isInitialized = true,
            defaultHomeScreen = Screen.Home.route
        )
    }
}

internal sealed interface MainUIState {
    data object Idle : MainUIState

    data object Loading : MainUIState

    data class Error(val message: String?) : MainUIState
}