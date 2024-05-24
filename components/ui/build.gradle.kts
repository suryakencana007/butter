plugins {
    alias(libs.plugins.butter.android.library)
    alias(libs.plugins.butter.android.library.compose)
}

android {
    namespace = "dev.kubuskotak.butter.components.ui"
}

dependencies {

    // compose
    api(libs.androidx.navigation.compose)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.android)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.ui.googlefonts)
}