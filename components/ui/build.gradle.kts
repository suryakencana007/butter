plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dev.kubuskotak.butter.components.ui"
    compileSdk = libs.versions.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    api(libs.androidx.navigation.compose)

    // compose
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.googlefonts)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.android)
}