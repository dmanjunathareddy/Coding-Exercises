package com.softgroup.hld.architectural.designpatterns.microsevices;

//API Gateway
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
