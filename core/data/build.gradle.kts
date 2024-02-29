import definition.Configs
import extensions.DOMAIN
import extensions.applyCoroutines
import extensions.applyHilt
import extensions.applyNetwork

plugins {
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
}

android {
    namespace = Configs.APP_NAMESPACE
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
}

dependencies {
    DOMAIN

    applyNetwork()
    applyCoroutines()
    applyHilt()
}