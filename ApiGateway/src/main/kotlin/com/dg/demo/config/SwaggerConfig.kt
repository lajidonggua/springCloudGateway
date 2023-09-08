package com.dg.demo.config

import org.springdoc.core.models.GroupedOpenApi
import org.springdoc.core.properties.SwaggerUiConfigParameters
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {


    @Bean
    fun apis(
        swaggerUiConfigParameters: SwaggerUiConfigParameters,
        locator: RouteDefinitionLocator
    ): List<GroupedOpenApi> {
        val groups = ArrayList<GroupedOpenApi>()
        val definitions = locator.routeDefinitions.collectList().block() ?: listOf()

        definitions.stream().filter { routeDefinition -> routeDefinition.id.matches(".*-service".toRegex()) }
            .forEach { routeDefinition ->
                val name = routeDefinition.id.replace("-service", "")
                swaggerUiConfigParameters.addGroup(name)
                groups.add(GroupedOpenApi.builder().pathsToMatch("/$name/**").group(name).build())
            }
        return groups
    }
}