package com.example.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer(){
//
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry
//						.addMapping("/**")
//						.allowedOriginPatterns("*")
//						.allowedHeaders("*")
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","HEAD")
//						.allowCredentials(false)
//						.maxAge(3600L);
//			}
//		};
//	}

}
