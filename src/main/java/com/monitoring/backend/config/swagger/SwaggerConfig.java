package com.monitoring.backend.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(){
		return new OpenAPI()
			.components(new Components())
			.info(apiInfo());
	}

	@Bean
	public Info apiInfo(){
		return new Info()
			.title("Container Monitoring swagger")
			.description("Container Monitoring swagger")
			.version("prototype");
	}
}
