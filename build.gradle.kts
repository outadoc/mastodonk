import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("com.diffplug.spotless") version "5.12.4"
    id("org.jetbrains.dokka") version "1.4.32"
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
    version = "0.1-alpha01"

    repositories {
        mavenCentral()
        google()
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
