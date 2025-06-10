plugins {
    `kotlin-dsl`
}
group = "com.ravikantsharma.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        // FOR PRESENTATION LAYER
        register("androidApplication") {
            id = libs.plugins.convention.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        // FOR PRESENTATION LAYER
        register("androidApplicationCompose") {
            id = libs.plugins.convention.android.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        // FOR DATA LAYER
        register("androidLibrary") {
            id = libs.plugins.convention.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        // FOR DOMAIN LAYER
        register("jvmLibrary") {
            id = libs.plugins.convention.jvm.library.get().pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}