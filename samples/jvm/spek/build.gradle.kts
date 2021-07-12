// Example project to show how to use Atrium in combination with Spek
// For more information on how to setup Atrium for a JVM project -> https://github.com/robstoll/atrium#jvm

import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.5.20"
}

group = "org.atriumlib.samples"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    val atrium_version = "0.16.0"
    val spek_version = "2.0.15"
    //spek requires jdk8, define dependency to stdlib-jdk at least in test
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // setup for Atrium:
    // for infix-api -> change artifact-id to 'atrium-infix-en_GB'
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:$atrium_version")

    // setup for 'spek', for some kotlin-version
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek_version")
}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2")
    }
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}
