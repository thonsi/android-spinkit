plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 37
    buildToolsVersion = "37.0.0"
    namespace = "com.thonsi.android.spinkit"

    defaultConfig {
        minSdk = 23
        targetSdkVersion = 37
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        abortOnError = false
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }

            groupId = "com.github.thonsi"
            artifactId = "android-spinkit"
            version = "0.0.2"

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
