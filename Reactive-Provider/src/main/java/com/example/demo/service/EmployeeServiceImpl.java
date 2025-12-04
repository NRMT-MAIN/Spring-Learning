package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository repo ; 
	
	@Override
	public Flux<Employee> findAllEmployees() {
		return repo.findAll().switchIfEmpty(Flux.empty()) ; 
	}
	
	@Override
	public Mono<Employee> getOneEmployee(String id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}
	
	@Override
	public Mono<Void> removeEmployee(String id) {
		return repo.deleteById(id); 
	}
	
	@Override
	public Mono<Employee> saveEmployee(Employee emp) {
		System.out.println("Service: Saving employee asynchronously.");
        return repo.save(emp); // Returns Mono
	}
	
}
