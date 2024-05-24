import com.android.build.gradle.LibraryExtension
import dev.kubuskotak.butter.configureGradleManagedDevices
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("butter.android.library")
                apply("butter.android.hilt")
            }
            extensions.configure<LibraryExtension>() {
                testOptions.animationsDisabled = true
                configureGradleManagedDevices(this)
            }

            dependencies {
                add("implementation", project(":components:ui"))
            }
        }
    }
}