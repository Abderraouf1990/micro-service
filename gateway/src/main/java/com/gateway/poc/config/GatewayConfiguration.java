package com.gateway.poc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route( p -> p.path("/messages/**")
	            .uri("http://localhost:8080/")
	            )
	        .route( p -> p.path("/products/**")
		            .uri("http://localhost:8080/")
		            )
	        /*.route(p -> p
	            .host("*.circuitbreaker.com")
	            .filters(f -> f.circuitBreaker(config -> config
	                .setName("mycmd")
	                //.setFallbackUri("forward:/fallback")
	                ))
	            .uri("http://httpbin.org:80"))*/
	        .build();
	}
}
