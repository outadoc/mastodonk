plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.mastodonkCore)
    implementation(libs.coroutines.core)
}
