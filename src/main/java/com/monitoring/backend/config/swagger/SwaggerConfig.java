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
			.openapi("3.0.1")
			.components(new Components())
			.info(apiInfo());
	}

	@Bean
	public Info apiInfo(){
		return new Info()
			.title("Container Monitoring API")
			.description("Container Monitoring API 명세서")
			.version("prototype-0.0.1");
	}
}
