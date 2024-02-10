package com.softgroup.hld.architectural.designpatterns.microsevices;

//Eureka Client
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
