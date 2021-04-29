import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    `maven-publish`
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

    publishing {
        repositories {
            maven {
                url = uri("https://maven.pkg.github.com/outadoc/mastodonk")
                credentials {
                    username = System.getenv("GHP_USERNAME")
                    password = System.getenv("GHP_TOKEN")
                }
            }
        }

        val publicationsFromMainHost = listOf(
            jvm().name,
            js().name,
            "kotlinMultiplatform"
        )

        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach {
                        onlyIf {
                            findProperty("isMainHost") == "true"
                        }
                    }
            }

            create<MavenPublication>("maven") {
                pom {
                    name.set("Mastodonk")
                    description.set("Kotlin/Multiplatform library for Mastodon")
                    url.set("https://github.com/outadoc/mastodonk")

                    issueManagement {
                        url.set("https://github.com/outadoc/mastodonk/issues")
                        system.set("GitHub Issues")
                    }
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            name.set("Baptiste Candellier")
                            email.set("baptiste@candellier.me")
                        }
                    }
                    scm {
                        connection.set("scm:git:git://github.com/outadoc/mastodonk.git")
                        developerConnection.set("scm:git:git://github.com/outadoc/mastodonk.git")
                        url.set("https://github.com/outadoc/mastodonk")
                    }
                }
            }
        }
    }

    sourceSets {

        // Common source-sets

        val commonMain by getting {
            dependencies {
                implementation(libs.datetime)
                implementation(libs.serialization)
                implementation(libs.ktor.core)
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

        val desktopTest by creating

        val linuxX64Main by getting { dependsOn(desktopMain) }
        val mingwX64Main by getting { dependsOn(desktopMain) }
        val macosX64Main by getting { dependsOn(desktopMain) }
    }
}

tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("README.md")
        }
    }
}
