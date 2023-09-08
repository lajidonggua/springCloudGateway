import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}
group = "com.dg"
version = ""

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

//repositories {
//	mavenCentral()
//}
repositories {
	maven {
		setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
	}
}
allprojects {
	group = "com.dg"
	version = ""
	repositories {
		maven {
			setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
		}
	}

	apply {
		plugin("java")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
		plugin("org.jetbrains.kotlin.jvm")
		plugin("org.jetbrains.kotlin.kapt")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}
	java.sourceCompatibility = JavaVersion.VERSION_17

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}
subprojects {

}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webflux-ui
	implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
