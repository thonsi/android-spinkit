plugins {
    id("com.android.application") version "9.5.3" apply false
    id("com.android.library") version "9.5.3" apply false
}

tasks.register<Delete>("clean") {
    description = "Delete rootProject buildDirectory"
    delete(rootProject.layout.buildDirectory)

    doLast {
        println("🧹 Cleaned rootProject buildDirectory")
    }
}