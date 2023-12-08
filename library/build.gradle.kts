plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    namespace = "com.thonsi.android.spinkit"

    defaultConfig {
        minSdk = 19
        targetSdk = 34
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

                group = "com.github.l1068"
                artifactId = "android-spinkit"
                version = "1.0.2"

                pom {
                    name.set("Android-SpinKit")
                    description.set("SpinKit for Android application")
                    url.set("https://github.com/l1068/android-spinkit")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            name.set("l1068")
                        }
                    }
                    scm {
                        connection.set("scm:git:https://github.com/l1068/android-spinkit")
                        url.set("https://github.com/l1068/android-spinkit")
                    }
                }
            }
        }
    }
}
