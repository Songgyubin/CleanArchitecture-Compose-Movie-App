import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.the

/**
 * 라이브러리 종속성 관리
 *
 * @author   Gyub
 * @created  2024/02/10
 */
object Dependencies {
    private val DependencyHandlerScope.libs get() = the<LibrariesForLibs>()

    const val COMPILE_SDK = 34
    const val MIN_SDK = 24
    const val TARGET_SDK = 34

    private const val implementation = "implementation"
    private const val testImplementation = "testImplementation"
    private const val androidTestImplementation = "androidTestImplementation"
    private const val debugImplementation = "debugImplementation"

    private const val kapt = "kapt"
    private const val kaptTest = "kaptTest"
    private const val kaptAndroidTest = "kaptAndroidTest"

    /**
     * AndroidX에 관한 종속성 적용
     */
    fun DependencyHandlerScope.applyAndroidX() {
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(libs.androidx.compose.ui)
        implementation(libs.androidx.compose.ui.graphics)
        implementation(libs.androidx.compose.ui.tooling.preivew)
        implementation(libs.androidx.compose.material3)
        implementation(libs.androidx.navigation.compose)
    }

    /**
     * 코루틴에 관한 종속성 적용
     */
    fun DependencyHandlerScope.applyCoroutines() {
        implementation(libs.coroutines.android)
        implementation(libs.coroutines.core)
    }

    /**
     * 네트워크 라이브러리에 관한 종속성 적용
     */
    fun DependencyHandlerScope.applyNetwork() {
        implementation(libs.okhttp3)
        implementation(libs.retrofit2)
        implementation(libs.retrofit2.converter.gson)
        implementation(libs.retrofit2.jackson)
        implementation(libs.okhttp3.logging.interceptor)
    }

    /**
     * Hilt에 관한 종속성 적용
     */
    fun DependencyHandlerScope.applyHilt() {
        implementation(libs.dagger.hilt)
        implementation(libs.dagger.hilt.compiler)
    }

    /**
     * Test에 관한 종속성 적용
     */
    fun DependencyHandlerScope.applyTest() {
        testImplementation(libs.test.junit)
        androidTestImplementation(libs.android.test.androidx.ext.junit)
        androidTestImplementation(libs.android.test.androidx.espresso.core)

        androidTestImplementation(platform(libs.android.test.androidx.compose.bom))
        androidTestImplementation(libs.android.test.androidx.espresso.core)

        debugImplementation(libs.debug.androidx.compose.ui.tooling)
        debugImplementation(libs.debug.androidx.compose.ui.test.manifest)
    }

    /**
     * implementation 구성으로 종속성을 추가
     */
    private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? = add(implementation, dependencyNotation)

    /**
     * androidTestImplementation 구성으로 종속성을 추가
     */
    private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? = add(androidTestImplementation, dependencyNotation)

    /**
     * testImplementation 구성으로 종속성을 추가
     */
    private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? = add(testImplementation, dependencyNotation)

    /**
     * debugImplementation 구성으로 종속성을 추가
     */
    private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? = add(debugImplementation, dependencyNotation)

    /**
     * kapt 구성으로 종속성을 추가
     */
    private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? = add(kapt, dependencyNotation)

    /**
     * kaptTest 구성으로 종속성을 추가
     */
    private fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? = add(kaptTest, dependencyNotation)

    /**
     * kaptAndroidTest 구성으로 종속성을 추가
     */
    private fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? = add(kaptAndroidTest, dependencyNotation)

    /**
     * Domain 모듈의 종속성을 implementation 구성으로 추가
     */
    val DependencyHandler.DOMAIN
        get() = implementation(project(mapOf("path" to ":domain")))

    /**
     * Data 모듈의 종속성을 api 구성으로 추가
     */
    val DependencyHandler.DATA
        get() = implementation(project(mapOf("path" to ":data")))
}