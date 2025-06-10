import com.android.build.api.dsl.ApplicationExtension
import com.ravikantsharma.convention.ext.ExtensionType
import com.ravikantsharma.convention.configurations.configureBuildType
import com.ravikantsharma.convention.configurations.configureKotlinAndroid
import com.ravikantsharma.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.findPlugin("android-application").get().get().pluginId)
            apply(plugin = libs.findPlugin("kotlin-android").get().get().pluginId)

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = libs.findVersion("compile-sdk").get().toString().toInt()
                    applicationId = libs.findVersion("applicationId").get().toString()

                    versionCode = libs.findVersion("version-code").get().toString().toInt()
                    versionName = libs.findVersion("version-name").get().toString()
                }
                configureKotlinAndroid(this)

                configureBuildType(
                    this,
                    ExtensionType.APPLICATION
                )
            }
        }
    }
}