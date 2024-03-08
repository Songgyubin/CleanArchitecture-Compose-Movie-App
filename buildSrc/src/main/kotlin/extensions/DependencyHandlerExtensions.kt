package extensions

import definition.Dependencies
import extensions.DependencyConst.ANDROID_TEST_IMPLEMENTATION
import extensions.DependencyConst.DEBUG_IMPLEMENTATION
import extensions.DependencyConst.IMPLEMENTATION
import extensions.DependencyConst.KAPT
import extensions.DependencyConst.KAPT_ANDROID_TEST
import extensions.DependencyConst.KAPT_TEST
import extensions.DependencyConst.TEST_IMPLEMENTATION
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * 종속성 관리 확장 함수
 *
 * @author   Gyub
 * @created  2024/02/10
 */

/**
 * AndroidX에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyAndroidX() {
    implementation(Dependencies.ANDROIDX_COMPOSE_BOM)
    implementation(Dependencies.ANDROIDX_CORE_KTX)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(Dependencies.ANDROIDX_COMPOSE_UI)
    implementation(Dependencies.ANDROIDX_COMPOSE_UI_TOOLING_PREIVEW)
//    implementation(Dependencies.ANDROIDX_COMPOSE_MATERIAL)
    implementation(Dependencies.ANDROIDX_COMPOSE_MATERIAL_3)
    implementation(Dependencies.ANDROIDX_NAVIGATION_COMPOSE)
}

/**
 * 코루틴에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyCoroutines() {
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.COROUTINES_CORE)
}

/**
 * 네트워크 라이브러리에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyNetwork() {
    implementation(Dependencies.OKHTTP3)
    implementation(Dependencies.RETROFIT2)
    implementation(Dependencies.RETROFIT2_CONVERTER_GSON)
    implementation(Dependencies.RETROFIT2_JACKSON)
    implementation(Dependencies.OKHTTP3_LOGGING_INTERCEPTOR)
}

/**
 * Hilt에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyHilt() {
    implementation(Dependencies.DAGGER_HILT)
    kapt(Dependencies.DAGGER_HILT_COMPILER)
}

/**
 * Google Lib에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyGoogle() {
    implementation(Dependencies.GSON)
}

/**
 * UI Test에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyUITest() {
    testImplementation(Dependencies.TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ANDROIDX_EXT_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(Dependencies.ANDROID_TEST_ANDROIDX_COMPOSE_BOM)
    debugImplementation(Dependencies.DEBUG_ANDROIDX_COMPOSE_UI_TOOLING)
    debugImplementation(Dependencies.DEBUG_ANDROIDX_COMPOSE_UI_TEST_MANIFEST)
}
/**
 * Unit Test에 관한 종속성 적용
 */
fun DependencyHandlerScope.applyUnitTest() {
    testImplementation(Dependencies.TEST_JUNIT)
    testImplementation(Dependencies.MOCKK)
    testImplementation(Dependencies.MOCK_WEB_SERVER)
}

/**
 * implementation 구성으로 종속성을 추가
 */
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? = add(IMPLEMENTATION, dependencyNotation)

/**
 * androidTestImplementation 구성으로 종속성을 추가
 */
private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? = add(ANDROID_TEST_IMPLEMENTATION, dependencyNotation)

/**
 * testImplementation 구성으로 종속성을 추가
 */
private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? = add(TEST_IMPLEMENTATION, dependencyNotation)

/**
 * debugImplementation 구성으로 종속성을 추가
 */
private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? = add(DEBUG_IMPLEMENTATION, dependencyNotation)

/**
 * kapt 구성으로 종속성을 추가
 */
private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? = add(KAPT, dependencyNotation)

/**
 * kaptTest 구성으로 종속성을 추가
 */
private fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? = add(KAPT_TEST, dependencyNotation)

/**
 * kaptAndroidTest 구성으로 종속성을 추가
 */
private fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? = add(KAPT_ANDROID_TEST, dependencyNotation)

/**
 * Domain 모듈의 종속성을 implementation 구성으로 추가
 */
val DependencyHandlerScope.DOMAIN
    get() = implementation(project(mapOf("path" to ":core:domain")))

/**
 * Data 모듈의 종속성을 api 구성으로 추가
 */
val DependencyHandler.DATA
    get() = implementation(project(mapOf("path" to ":core:data")))

/**
 * Network 모듈의 종속성을 api 구성으로 추가
 */
val DependencyHandler.NETWORK
    get() = implementation(project(mapOf("path" to ":core:network")))

/**
 * Common 모듈의 종속성을 api 구성으로 추가
 */
val DependencyHandler.COMMON
    get() = implementation(project(mapOf("path" to ":core:common")))


object DependencyConst {
    const val IMPLEMENTATION = "implementation"
    const val TEST_IMPLEMENTATION = "testImplementation"
    const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
    const val DEBUG_IMPLEMENTATION = "debugImplementation"

    const val KAPT = "kapt"
    const val KAPT_TEST = "kaptTest"
    const val KAPT_ANDROID_TEST = "kaptAndroidTest"
}