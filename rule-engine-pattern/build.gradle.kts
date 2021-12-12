plugins {
    java
}

group = "io.plagov"
version = "1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
