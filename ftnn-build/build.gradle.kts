plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.1")
    implementation("javassist:javassist:3.12.1.GA")
    testImplementation("junit:junit:4.+")
}