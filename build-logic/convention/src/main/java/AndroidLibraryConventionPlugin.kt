import com.android.build.gradle.LibraryExtension
import com.ravikantsharma.convention.configurations.configureBuildType
import com.ravikantsharma.convention.configurations.configureKotlinAndroid
import com.ravikantsharma.convention.ext.ExtensionType
import com.ravikantsharma.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.findPlugin("android-library").get().get().pluginId)
            apply(plugin = libs.findPlugin("kotlin-android").get().get().pluginId)

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildType(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }
    }
}