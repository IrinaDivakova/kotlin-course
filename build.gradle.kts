plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1") // Убедитесь, что версия актуальная
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}