package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.service.IEmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeManagementController {
	@Autowired
	private IEmployeeService service ; 
	
    @PostMapping("/save")
    public Mono<Employee> saveOneEmployee(@RequestBody Employee employee) {
        System.out.println("Controller: Received asynchronous save request.");
        return service.saveEmployee(employee);
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmps() {
        return service.findAllEmployees();
    }

    @GetMapping("/one/{id}")
    public Mono<Employee> getOneEmployee(@PathVariable String id) {
        return service.getOneEmployee(id);
    }

    @DeleteMapping("/remove/{id}")
    public Mono<Void> removeEmployee(@PathVariable String id) {
        return service.removeEmployee(id);
    }
}
