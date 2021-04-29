plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

dependencies {
    api(projects.mastodonkCore)
    implementation(libs.androidx.paging.common)
}
