package com.app.financialmanagement.configuration;

import com.app.financialmanagement.configuration.properties.OpenApiConfigurationProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(OpenApiConfigurationProperties.class)
public class OpenApiConfiguration {

    private final OpenApiConfigurationProperties openApiConfigurationProperties;

    @Bean
    public OpenAPI customOpenApi(){
        final var properties = openApiConfigurationProperties.getProperties();
        final var security = properties.getSecurity();
        final var contact = properties.getContact();

        return new OpenAPI().info(
                new Info().title(properties.getTitle())
                        .version(properties.getApiVersion())
                        .description(properties.getDescription())
                        .contact(new Contact()
                                        .email(contact.getEmail())
                                        .name(contact.getName())
                                        .url(contact.getUrl())
                        )
        )
                .addSecurityItem(new SecurityRequirement().addList(security.getName()))
                .components(new Components().addSecuritySchemes(security.getName()
                        ,new SecurityScheme().name(security.getName())
                                .type(SecurityScheme.Type.HTTP)
                                .scheme(security.getScheme())
                                .bearerFormat(security.getBearerFormat())
                        )
                );
    }



}
