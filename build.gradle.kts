import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`maven-publish`
	kotlin("jvm") version "1.6.21"
}

group = "nextstep"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("nextstep:interpreter:1.0.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "nextstep"
			artifactId = "compiler"
			version = "1.0.0"

			from(components["java"])
		}
	}
}
