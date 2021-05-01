import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("com.diffplug.spotless") version "5.12.4"
    id("org.jetbrains.dokka") version "1.4.32"
    `maven-publish`
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    val kotlinVersion = "1.5.0"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}

allprojects {
    group = "fr.outadoc.mastodonk"
    version = "0.1-alpha10"

    repositories {
        mavenCentral()
        google()
    }
}

subprojects {
    val projectName = name
    val isMainHost = findProperty("isMainHost") == "true"
    val isLibraryProject = projectName.startsWith("mastodonk-")

    if (isLibraryProject) {
        apply(plugin = "org.gradle.maven-publish")

        publishing {
            repositories {
                maven {
                    name = "nexus"
                    url = uri("https://nexus.outadoc.fr/repository/public")
                    credentials {
                        username = System.getenv("NEXUS_USERNAME")
                        password = System.getenv("NEXUS_PASSWORD")
                    }
                }
            }

            val publicationsFromMainHost = listOf(
                "maven", "jvm", "js", "kotlinMultiplatform"
            )

            publications {
                matching { it.name in publicationsFromMainHost }
                    .all {
                        val targetPublication = this
                        tasks.withType<AbstractPublishToMaven>()
                            .matching { it.publication == targetPublication }
                            .configureEach { onlyIf { isMainHost } }
                    }

                create<MavenPublication>("maven") {
                    pom {
                        name.set(projectName)
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
    }
}

configure<SpotlessExtension> {
    format("misc") {
        target(
            "**/*.kt",
            "**/*.kts",
            "**/*.md",
            "**/.gitignore"
        )

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}
