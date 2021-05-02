import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

kotlin {
    explicitApi()

    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.mastodonkCore)
            }
        }
        val commonTest by getting

        val jvmMain by getting {
            dependencies {
                implementation(libs.androidx.paging.common)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("README.md")
        }
    }
}
