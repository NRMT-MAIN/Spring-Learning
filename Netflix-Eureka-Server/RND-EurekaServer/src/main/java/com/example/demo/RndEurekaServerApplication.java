package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class RndEurekaServerApplication {

	public static void main(String[] args) {
		log.info("Start of the Eureka Server!");
		SpringApplication.run(RndEurekaServerApplication.class, args);
		log.info("End of the application!");
	}

}
