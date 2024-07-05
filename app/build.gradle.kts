plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.marvelherosapp"
    compileSdk = 34
    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "com.example.marvelherosapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Main Compose dependencies
    implementation("androidx.compose.material:material:1.6.8") // Latest version
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")

    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Only keeping the necessary dependencies
    implementation("androidx.compose.ui:ui-tooling:1.6.8")

    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("io.coil-kt:coil-compose:2.6.0")

    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.ui:ui:1.6.8")
    implementation("androidx.compose.runtime:runtime:1.4.3")
    implementation("androidx.compose.ui:ui-util:1.4.3")

    // Optional dependencies
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.runtime:runtime-rxjava2")

    // Other dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Debug dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
//    implementation("androidx.compose.material:material:1.0.5")
//    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
//
//
//    implementation(libs.androidx.navigation.runtime.ktx)
//    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.material3.android)
//    implementation(libs.androidx.databinding.compiler)
//    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
//    implementation(composeBom)
//    androidTestImplementation(composeBom)
//
////    implementation("androidx.compose.ui:ui:1.3.0")
////    implementation("androidx.compose.material:material:1.3.0")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
//    implementation("androidx.activity:activity-compose:1.9.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
//    implementation("io.coil-kt:coil-compose:2.6.0")
//
//    implementation("androidx.compose.foundation:foundation:1.4.3")
//    implementation("androidx.compose.material:material:1.6.8")
//    implementation("androidx.compose.ui:ui:1.6.8")
//    implementation("androidx.compose.runtime:runtime:1.4.3")
//    implementation("androidx.compose.ui:ui-util:1.4.3")
//
//
//    // Material Design 3
////    implementation("androidx.compose.material3:material3")
//    // or Material Design 2
//    implementation("androidx.compose.material:material")
//    // or skip Material Design and build directly on top of foundational components
//    implementation("androidx.compose.foundation:foundation")
//    // or only import the main APIs for the underlying toolkit systems,
//    // such as input and measurement/layout
//    implementation("androidx.compose.ui:ui")
//
//    // Android Studio Preview support
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//
//    // UI Tests
////    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
////    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
//    // Optional - Included automatically by material, only add when you need
//    // the icons but not the material library (e.g. when using Material3 or a
//    // custom design system based on Foundation)
//    implementation("androidx.compose.material:material-icons-core")
//    // Optional - Add full set of material icons
//    implementation("androidx.compose.material:material-icons-extended")
//    // Optional - Add window size utils
////    implementation("androidx.compose.material3:material3-window-size-class")
//
//    // Optional - Integration with activities
//    implementation("androidx.activity:activity-compose:1.9.0")
//    // Optional - Integration with ViewModels
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
//    // Optional - Integration with LiveData
//    implementation("androidx.compose.runtime:runtime-livedata")
//    // Optional - Integration with RxJava
//    implementation("androidx.compose.runtime:runtime-rxjava2")
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}