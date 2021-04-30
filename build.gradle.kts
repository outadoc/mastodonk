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
    version = "0.1-alpha02"

    repositories {
        mavenCentral()
        google()
    }
}

subprojects {
    if (name.startsWith("mastodonk-")) {
        apply(plugin = "org.gradle.maven-publish")

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

            publications {
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
