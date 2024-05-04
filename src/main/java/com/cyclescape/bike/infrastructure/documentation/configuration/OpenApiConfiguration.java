package com.cyclescape.bike.infrastructure.documentation.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI CyclespacePlatformOpenApi(
        @Value("${openapi.service.title}") String serviceTitle,
        @Value("${openapi.service.version}") String serviceVersion,
        @Value("${openapi.service.url}") String url
    ) {
        return new OpenAPI()
                .servers(List.of(new Server().url(url)))
                .info(new Info()
                        .title(serviceTitle)
                        .description(serviceTitle + " documentation")
                        .version(serviceVersion)
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Cyclespace API wiki Documentation")
                        .url("https://Cyclespace-api.wiki.github.io/docs"));
    }
}