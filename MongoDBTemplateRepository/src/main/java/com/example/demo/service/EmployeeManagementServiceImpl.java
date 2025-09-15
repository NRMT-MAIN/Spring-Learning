package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {
	
	@Autowired
	private MongoTemplate template ; 
	
	@Override
	public String registerEmployee(Employee emp) {
		String idVal = template.insert(emp).getId() ; 
		
		return "Employee is inserted with id :: " + idVal ; 
	}
	
	@Override
	public String registerBatchEmployee(List<Employee> list) {
		int size = template.insertAll(list).size() ; 
		
		return size + " Employee are saved!" ; 
	}
}
