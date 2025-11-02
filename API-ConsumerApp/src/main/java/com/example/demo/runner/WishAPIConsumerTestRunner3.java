package com.example.demo.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishAPIConsumerTestRunner3 implements CommandLineRunner {
	private static final String SERVICE_URL = 
	        "http://localhost:3030/wish-api/register"; 
	
	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate() ; 
		
		
		String json_body="{ \"aid\" : 1001, \"name\": \"suresh\",\"aadrss\": \"Pune\",\"income\":7800.0}";
		
		HttpHeaders headers = new HttpHeaders() ; 
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> req = new HttpEntity<String>(json_body , headers) ; 
		
		ResponseEntity<String> res = template.postForEntity(SERVICE_URL, req, String.class) ; 
		
		System.out.println("\n--- Response Details (getForEntity) ---");
        System.out.println("Response body (Output) :: " + res.getBody());
        System.out.println("Response Status Code :: " + res.getStatusCode());
        System.out.println("Response Status Code Value :: " + res.getStatusCodeValue());
        
	}
}
