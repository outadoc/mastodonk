import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    `java-library`
    id("org.jetbrains.dokka")
}

kotlin {
    explicitApi()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(projects.mastodonkCore)
    implementation(libs.androidx.paging.common)
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("README.md")
        }
    }
}
