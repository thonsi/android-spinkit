pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex(".*google.*")
                includeGroupByRegex(".*android.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex(".*google.*")
                includeGroupByRegex(".*android.*")
            }
        }
        mavenCentral()
        maven("https://jitpack.io")
    }
}

plugins {
    id("com.gradle.develocity") version "4.5.0"
	id("com.android.settings") version "9.3.1"
}

develocity {
  buildScan {
    termsOfUseUrl = "https://gradle.com/terms-of-service"
    termsOfUseAgree = "yes"
    // TODO: workaround for https://github.com/gradle/gradle/issues/22879.
    val isCI = providers.environmentVariable("CI").isPresent
    publishing.onlyIf { isCI }
  }
}

android {
    compileSdk = 37
    minSdk = 23
    targetSdk = 37
    buildToolsVersion = "37.0.0"
}
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "android-spinkit"
include(":sample", ":library")
