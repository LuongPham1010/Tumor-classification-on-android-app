plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.braintumordemoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.braintumordemoapp"
        minSdk = 21
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        mlModelBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.tensorflow.lite.support)
    implementation(libs.tensorflow.lite.metadata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("org.tensorflow:tensorflow-lite:2.6.0")// Thay x bằng phiên bản cụ thể
    implementation("org.tensorflow:tensorflow-lite-gpu:2.6.0")// Nếu bạn muốn hỗ trợ GPU
    implementation("org.tensorflow:tensorflow-lite-support:0.0.0-nightly")// Thư viện hỗ trợ mới nhất



}