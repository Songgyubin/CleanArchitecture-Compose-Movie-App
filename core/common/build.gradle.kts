import definition.Configs
import definition.Configs.COMMON_NAMESPACE
import extensions.applyHilt

plugins {
    id(Plugins.ANDROID_LIBRARY_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
}

android {
    namespace = COMMON_NAMESPACE
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        minSdk = Configs.MIN_SDK

        testInstrumentationRunner = Configs.TEST_INSTRUMENTATION_RUNNER
    }

    kotlinOptions {
        jvmTarget = Configs.JVM_TARGET
    }
}

dependencies {
    applyHilt()
}
