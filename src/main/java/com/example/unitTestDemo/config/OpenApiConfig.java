package com.example.unitTestDemo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(new Info()
                        .title("Unit Test Demo API")
                        .description("""
                                REST API for managing users.

                                This API demonstrates:
                                - CRUD operations
                                - Spring Boot REST
                                - H2 Database
                                - Swagger/OpenAPI Documentation
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Sangeevan")
                                .email("sangeevan@gmail.com")
                                .url("https://github.com/Sangeevan"))
                        .license(new License()
                                .name("Apache License 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))

                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Local Development Server"))

                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation")
                        .url("https://github.com/Sangeevan/automationDemo"));
    }
}
