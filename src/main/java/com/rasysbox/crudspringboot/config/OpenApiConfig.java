package com.rasysbox.crudspringboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${api.title}")
    private String title;

    @Value("${api.version}")
    private String version;

    @Value("${api.description}")
    private String description;

    @Value("${api.contact.name}")
    private String contactName;

    @Value("${api.contact.url}")
    private String contactUrl;

    @Value("${api.contact.email}")
    private String contactEmail;

    @Value("${api.license.name}")
    private String licenseName;

    @Value("${api.license.url}")
    private String licenseUrl;

    @Value("${api.server.local.url}")
    private String localServerUrl;

    @Value("${api.server.local.description}")
    private String localServerDescription;

    @Value("${api.server.production.url}")
    private String productionServerUrl;

    @Value("${api.server.production.description}")
    private String productionServerDescription;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                        .contact(new Contact()
                                .name(contactName)
                                .url(contactUrl)
                                .email(contactEmail))
                        .license(new License()
                                .name(licenseName)
                                .url(licenseUrl)))
                .servers(List.of(
                        new Server().url(localServerUrl).description(localServerDescription),
                        new Server().url(productionServerUrl).description(productionServerDescription)
                ));
    }
}
