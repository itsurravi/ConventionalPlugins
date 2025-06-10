import com.ravikantsharma.convention.configurations.configureKotlinJvm
import com.ravikantsharma.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class JvmLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.findPlugin("jetbrains-kotlin-jvm").get().get().pluginId)

            configureKotlinJvm()
        }
    }
}