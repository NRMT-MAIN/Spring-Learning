package com.example.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishAPIConsumerTestRunner2 implements CommandLineRunner {
	private static final String SERVICE_URL = 
	        "http://localhost:3030/wish-api/wish/{id}/{name}"; 
	
	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate() ; 
		
		ResponseEntity<String> res = template.getForEntity(SERVICE_URL, String.class , 1001 , "Nirmit") ; 
		
		System.out.println("\n--- Response Details (getForEntity) ---");
        System.out.println("Response body (Output) :: " + res.getBody());
        System.out.println("Response Status Code :: " + res.getStatusCode());
        System.out.println("Response Status Code Value :: " + res.getStatusCodeValue());
        
        String resultBody = template.getForObject(SERVICE_URL, String.class , 1101 , "Sahu");
        System.out.println("\n--- Response Details (getForObject) ---");
        System.out.println("Result (Body Only) :: " + resultBody);
		
	}
}
