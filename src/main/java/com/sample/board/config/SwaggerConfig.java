package com.sample.board.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Web-Service API Document",
                description = "Web-Service API Project Swagger",
                version = "v1"))
@Configuration
public class SwaggerConfig {

}
