package com.rasysbox.crudspringboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API of Users",
                version = "1.0.0",
                description = "API for managing users",
                contact = @Contact(
                        name = "Raul Bolivar Navas",
                        url = "https://rasysbox.com",
                        email = "rasysbox@hotmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
                @Server(url = "https://rasysbox.com", description = "Production Server")
        }
)
public class OpenApiConfig {}
