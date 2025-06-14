import com.android.build.api.dsl.ApplicationExtension
import com.ravikantsharma.convention.configurations.configureAndroidCompose
import com.ravikantsharma.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.findPlugin("convention-android-application").get().get().pluginId)
            apply(plugin = libs.findPlugin("kotlin-compose").get().get().pluginId)

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}