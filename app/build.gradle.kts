import definition.Configs
import extensions.COMMON
import extensions.DATA
import extensions.DOMAIN
import extensions.applyAndroidX
import extensions.applyCoroutines
import extensions.applyHilt
import extensions.applyNetwork
import extensions.applyUITest

plugins {
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
}

android {
    namespace = Configs.APP_NAMESPACE
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        applicationId = Configs.ID
        minSdk = Configs.MIN_SDK
        targetSdk = Configs.TARGET_SDK
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        testInstrumentationRunner = Configs.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Configs.KOTLIN_COMPILER_EXTENSION_VERSION
    }
    packaging {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    DATA
    DOMAIN
    COMMON

    applyAndroidX()
    applyCoroutines()
    applyNetwork()
    applyHilt()
    applyUITest()
}