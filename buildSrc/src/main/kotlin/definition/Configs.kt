package definition

/**
 * 컨피그 관리
 *
 * @author   Gyub
 * @created  2024/02/10
 */
object Configs {
    private const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MjY4ZTg1OTNjYzc0ZDhjZWVlMDhmMmRlZTg1N2NjNyIsInN1YiI6IjY1ZDQyNzk3MDlkZGE0MDE4ODU3YjlkZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.x4ffATm767ZkEY0PgPYv7IHbCwhnkg3M-fcQ7WGNht0"

    private const val versionMajor = 0
    private const val versionMinor = 0
    private const val versionPatch = 0

    const val ID = "com.gyub.movieapp"
    const val MIN_SDK = 24
    const val TARGET_SDK = 34
    const val COMPILE_SDK = 34

    const val APP_NAMESPACE = "com.gyub.movieapp"
    const val DATA_NAMESPACE = "com.gyub.core.data"
    const val DOMAIN_NAMESPACE = "com.gyub.core.domain"
    const val NETWORK_NAMESPACE = "com.gyub.core.network"
    const val COMMON_NAMESPACE = "com.gyub.core.common"

    const val VERSION_CODE = 1000000
    const val VERSION_NAME = "$versionMajor.$versionMinor.$versionPatch"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val PROGUARD_ANDROID_OPTIMIZE = "proguard-android-optimize.txt"
    const val PROGUARD_RULES = "proguard-rules.pro"

    val excludePackagingOptions = mutableSetOf(
        "/META-INF/{AL2.0,LGPL2.1}"
    )

    const val JVM_TARGET = "1.8"
    const val KOTLIN_COMPILER_EXTENSION_VERSION = "1.5.10"
}