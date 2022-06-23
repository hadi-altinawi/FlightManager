import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "com.altinawi"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    val kotlinVersion = project.getKotlinPluginVersion()
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("junit:junit:4.13.2")
    implementation("org.assertj:assertj-core:3.23.1")
    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}