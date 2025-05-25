plugins {
    id("java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // your existing test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.0")
    testImplementation("org.hamcrest:hamcrest-core:3.0")
    testImplementation("org.hamcrest:hamcrest-library:3.0")
    testImplementation("org.mockito:mockito-core:5.12.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.12.0")

    // make sure the launcher version matches the platform engine (1.12.0 for JUnit-Jupiter 5.12.0)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.12.0")
}

tasks.test {
    useJUnitPlatform()
}