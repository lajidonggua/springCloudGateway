dependencies {
    // https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-gateway
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:4.0.7"){
        exclude("org.yaml","snakeyaml")
    }
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.3")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")
}
