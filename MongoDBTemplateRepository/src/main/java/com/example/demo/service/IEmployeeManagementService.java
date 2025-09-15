package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface IEmployeeManagementService {
	public String registerEmployee(Employee emp) ; 
	public String registerBatchEmployee(List<Employee> list) ; 
}
