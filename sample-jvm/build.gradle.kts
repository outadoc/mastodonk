plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.mastodonkCore)
    implementation(libs.coroutines.core)
}

application {
    mainClass.set("fr.outadoc.mastodonk.sample.SampleKt")
}
