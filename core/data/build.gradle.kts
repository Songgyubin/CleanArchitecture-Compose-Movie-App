import definition.Configs
import extensions.COMMON
import extensions.DOMAIN
import extensions.NETWORK
import extensions.applyCoroutines
import extensions.applyGoogle
import extensions.applyHilt
import extensions.applyNetwork

plugins {
    id(Plugins.ANDROID_LIBRARY_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
}

android {
    namespace = Configs.DATA_NAMESPACE
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        minSdk = Configs.MIN_SDK

        testInstrumentationRunner = Configs.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(Configs.PROGUARD_ANDROID_OPTIMIZE), Configs.PROGUARD_RULES)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Configs.JVM_TARGET
    }
    packaging {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    DOMAIN
    NETWORK
    COMMON

    applyNetwork()
    applyCoroutines()
    applyHilt()
    applyGoogle()
}