plugins {
    alias(libs.plugins.convention.android.compose)
}

android {
    namespace = "com.ravikantsharma.conventionalpluginssample"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}