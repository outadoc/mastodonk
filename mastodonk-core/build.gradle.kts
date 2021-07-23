import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
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

    js(IR) {
        browser()
        nodejs()
    }

    linuxX64()
    macosX64()
    mingwX64()

    sourceSets {

        // Common source-sets

        val commonMain by getting {
            dependencies {
                implementation(libs.datetime)
                implementation(libs.serialization)
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.websockets)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // JVM source-sets

        val jvmMain by getting {
            dependencies {
                implementation(libs.ktor.engine.cio)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        // JS source-sets

        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.engine.js)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        // Desktop source-sets

        val desktopMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.ktor.engine.curl)
            }
        }

        val linuxX64Main by getting { dependsOn(desktopMain) }
        val mingwX64Main by getting { dependsOn(desktopMain) }
        val macosX64Main by getting { dependsOn(desktopMain) }

        val desktopTest by creating {
            dependsOn(commonTest)
        }

        val linuxX64Test by getting { dependsOn(desktopTest) }
        val mingwX64Test by getting { dependsOn(desktopTest) }
        val macosX64Test by getting { dependsOn(desktopTest) }
    }
}

tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("README.md")
        }
    }
}
