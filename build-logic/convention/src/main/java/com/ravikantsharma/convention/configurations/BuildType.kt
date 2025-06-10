package com.ravikantsharma.convention.configurations

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.ravikantsharma.convention.ext.ExtensionType
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildType(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionType: ExtensionType
) {
    commonExtension.apply {
        buildFeatures {
            buildConfig = true
        }

        when (extensionType) {
            ExtensionType.APPLICATION -> {
                extensions.configure<ApplicationExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuild()
                        }
                        release {
                            configureReleaseBuild(commonExtension)
                        }
                    }
                }
            }

            ExtensionType.LIBRARY -> {
                extensions.configure<LibraryExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuild()
                        }
                        release {
                            configureReleaseBuild(commonExtension)
                        }
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuild() {
    // Place configurations for debug build that needs to be place inside debug { }
}

private fun BuildType.configureReleaseBuild(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    isMinifyEnabled = true
    proguardFiles(commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
}