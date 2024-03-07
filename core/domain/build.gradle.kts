import definition.Configs
import extensions.COMMON
import extensions.applyCoroutines
import extensions.applyHilt
import extensions.applyUnitTest

plugins {
    id(Plugins.ANDROID_LIBRARY_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
}

android {
    namespace = Configs.DOMAIN_NAMESPACE
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        minSdk = Configs.MIN_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packaging {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    COMMON

    applyHilt()
    applyCoroutines()
    applyUnitTest()
}