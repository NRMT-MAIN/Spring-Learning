package com.example.demo.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.Employee;

import reactor.core.publisher.Mono;

@Component
public class SaveDocumentTestRunner implements CommandLineRunner {
	private final String BASE_URL = "http://localhost:5051";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Client Runner: Saving Document (POST) ---");
        WebClient client = WebClient.create(BASE_URL);
        
        Employee newEmp = new Employee(null, "A-QA", "QA", 3300.0); 
        Mono<Employee> mono = client.post()
            .uri("/employee/save")
            .body(Mono.just(newEmp), Employee.class) 
            .retrieve()
            .bodyToMono(Employee.class); 

        // Subscribe to block until the result is ready (for testing/console output)
        mono.subscribe(
            savedEmp -> System.out.println("Saved Employee: " + savedEmp),
            error -> System.err.println("Error saving: " + error.getMessage())
        );
    }
}
