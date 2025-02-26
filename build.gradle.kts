plugins {
    id("com.android.application") version "8.7.3" apply false
    id("com.android.library") version "8.8.2" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
