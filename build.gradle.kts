plugins {
    kotlin("jvm") version "1.4.21"
    jacoco
    id("pl.droidsonroids.jacoco.testkit") version "1.0.7"
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    id("io.gitlab.arturbosch.detekt") version "1.14.1"
}

repositories {
    jcenter()
}

dependencies {
    testImplementation(gradleTestKit())
    val kotestVersion = "4.4.3"
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion") // for kotest core assertions
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion") // for kotest core jvm assertions
}