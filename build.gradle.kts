plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.3"
}

version = "0.1"
group = "com.example"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
    implementation("io.micronaut.serde:micronaut-serde-jackson:1.3.3")
    implementation("com.willowtreeapps.assertk:assertk:0.25")
    kapt("io.micronaut:micronaut-http-validation:3.7.4")
    implementation("io.micronaut:micronaut-http-client:3.7.4")
    implementation("io.micronaut:micronaut-jackson-databind:3.7.4")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.2.2")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.5")
    implementation("io.micronaut:micronaut-validation:3.7.4")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")

}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}



