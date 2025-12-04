package com.example.demo.service;

import com.example.demo.models.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
	public Mono<Employee> saveEmployee(Employee emp);
    public Flux<Employee> findAllEmployees();
    public Mono<Employee> getOneEmployee(String id); 
    public Mono<Void> removeEmployee(String id);
}
