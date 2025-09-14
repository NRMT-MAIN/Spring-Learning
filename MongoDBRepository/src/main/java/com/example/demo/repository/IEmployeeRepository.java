package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
	
	public List<Employee> findByEsalBetween(double startSalary , double endSalary) ; 
	public List<Employee> findByEnameIn(String ...names) ; 

}
