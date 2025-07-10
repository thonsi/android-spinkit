plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 35
    buildToolsVersion = "35.0.0"
    namespace = "com.thonsi.android.spinkit"

    defaultConfig {
        minSdk = 21
        targetSdk = 35
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        abortOnError = false
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components.findByName("release"))

                group = "com.github.thonsi"
                artifactId = "android-spinkit"
                version = "1.0.4"

                pom {
                    name.set("Android-SpinKit")
                    description.set("SpinKit for Android application")
                    url.set("https://github.com/thonsi/android-spinkit")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            name.set("thonsi")
                        }
                    }
                    scm {
                        connection.set("scm:git:https://github.com/thonsi/android-spinkit")
                        url.set("https://github.com/thonsi/android-spinkit")
                    }
                }
            }
        }
    }
}
