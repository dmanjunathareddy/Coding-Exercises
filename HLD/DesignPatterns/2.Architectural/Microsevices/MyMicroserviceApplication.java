package com.softgroup.hld.architectural.designpatterns.microsevices;

//Hystrix-enabled Microservice
//Circuit Breaker Pattern (Hystrix - Netflix OSS)
@SpringBootApplication
@EnableCircuitBreaker
public class MyMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyMicroserviceApplication.class, args);
	}
}
