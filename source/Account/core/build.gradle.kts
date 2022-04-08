plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("plugin.spring")
    kotlin("plugin.serialization")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":contracts"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("io.github.microutils:kotlin-logging:2.1.21")

    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.6")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))
    testImplementation("com.appmattus.fixture:fixture:1.2.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
