dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("gradle/movie.libs.toml"))
        }
    }
}

rootProject.name = "CleanArchitecture-Compose-Movie-App"