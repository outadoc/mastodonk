plugins {
    kotlin("jvm") version "1.4.32"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.mastodonkCore)
    implementation(libs.coroutines.core)
}
