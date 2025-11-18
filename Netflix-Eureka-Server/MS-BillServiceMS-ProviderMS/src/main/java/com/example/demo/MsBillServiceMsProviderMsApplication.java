package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class MsBillServiceMsProviderMsApplication {

	public static void main(String[] args) {
		log.info("Start of the Main method");
		SpringApplication.run(MsBillServiceMsProviderMsApplication.class, args);
		log.info("Application is bootstraped!");
		log.info("End of the Application");
	}

}
