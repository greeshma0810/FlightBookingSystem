package com.capg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@ComponentScan(basePackages = "com.capg.entity")
@ComponentScan(basePackages = "com.capg.controller")
@ComponentScan(basePackages = "com.capg.service")
@ComponentScan(basePackages = "com.capg.dto")

@EnableMongoRepositories("com.capg.repository")
@EnableEurekaClient
public class FlightSearchApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
	}

	
}
