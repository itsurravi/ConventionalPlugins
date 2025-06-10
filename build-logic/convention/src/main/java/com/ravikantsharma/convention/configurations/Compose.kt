package com.ravikantsharma.convention.configurations

import com.android.build.api.dsl.CommonExtension
import com.ravikantsharma.convention.ext.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            "implementation"(platform(bom))
            "androidTestImplementation"(platform(bom))
            "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
            "implementation"(project.libs.findBundle("compose").get())
            "debugImplementation"(project.libs.findBundle("compose.debug").get())
            "androidTestImplementation"(project.libs.findBundle("compose.test").get())
        }
    }
}