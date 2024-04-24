package definition

/**
 * 라이브러리 종속성 관리
 *
 * @author   Gyub
 * @created  2024/02/10
 */
object Dependencies {

    /**
     * AndroidX
     */
    const val ANDROIDX_COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.ANDROIDX_COMPOSE_BOM}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX}"
    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_LIFECYCLE}"
    const val ANDROIDX_ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    const val ANDROIDX_COMPOSE_UI = "androidx.compose.ui:ui:${Versions.ANDROIDX_COMPOSE_UI}"
    const val ANDROIDX_COMPOSE_UI_TOOLING_PREIVEW = "androidx.compose.ui:ui-tooling-preview:${Versions.ANDROIDX_COMPOSE_UI}"
    const val ANDROIDX_COMPOSE_MATERIAL_3 =  "androidx.compose.material3:material3:${Versions.ANDROIDX_COMPOSE_MATERIAL_3}"
    const val ANDROIDX_NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.ANDROIDX_NAVIGATION_COMPOSE}"
    const val ANDROIDX_HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.ANDROIDX_HILT_NAVIGATION_COMPOSE}"
    const val ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.ANDROIDX_LIFECYCLE}"
    /**
     * Coroutines
     */
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"

    /**
     * Network
     */
    const val OKHTTP3 = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP3}"
    const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2}"
    const val RETROFIT2_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2_CONVERTER_GSON}"
    const val RETROFIT2_JACKSON = "com.squareup.retrofit2:converter-jackson:${Versions.RETROFIT2_JACKSON}"
    const val OKHTTP3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3_LOGGING_INTERCEPTOR}"

    /**
     * HILT
     */
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT}"
    const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT_COMPILER}"

    /**
     * COIL
     */
    const val COIL_KT = "io.coil-kt:coil:${Versions.COIL_KT}"
    const val COIL_KT_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL_KT}"

    /**
     * Google Library
     */
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    /**
     * UI TEST
     */
    const val ANDROID_TEST_ANDROIDX_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_TEST_ANDROIDX_EXT_JUNIT}"
    const val ANDROID_TEST_ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ANDROID_TEST_ANDROIDX_ESPRESSO_CORE}"
    const val ANDROID_TEST_ANDROIDX_COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.ANDROID_TEST_ANDROIDX_COMPOSE_BOM}"
    const val DEBUG_ANDROIDX_COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
    const val DEBUG_ANDROIDX_COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"

    /**
     * Unit Test
     */
    const val TEST_JUNIT = "junit:junit:${Versions.TEST_JUNIT}"
    const val MOCKK = "io.mockk:mockk:${Versions.TEST_MOCKK}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.TEST_MOCK_WEB_SERVER}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
}