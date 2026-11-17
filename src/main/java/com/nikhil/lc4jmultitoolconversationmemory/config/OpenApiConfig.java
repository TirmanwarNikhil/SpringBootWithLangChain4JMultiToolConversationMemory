package com.nikhil.lc4jmultitoolconversationmemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		return new OpenAPI()
				.info(new Info().title("Spring Boot LangChain4j Multi-Tool API").version("1.0.0").description("""
						AI-powered E-commerce Customer Support API.

						The AI assistant can dynamically select
						Order, Payment, Customer and Shipment tools.
						""").contact(new Contact().name("Development Team")));
	}
}