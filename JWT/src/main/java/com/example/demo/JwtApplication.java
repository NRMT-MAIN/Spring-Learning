package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.utils.JWTUtils;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
		String token = JWTUtils.generateToken("5435AA", "RAJA", "RANI_SECRET_KEY_123");
        
        System.out.println("Generated JWT Token:\n" + token);
	}

}
