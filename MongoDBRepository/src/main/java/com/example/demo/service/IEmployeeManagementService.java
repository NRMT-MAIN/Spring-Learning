package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface IEmployeeManagementService {
	public String registerEmployee(Employee emp) ; 
	public String[] registerEmployees(List<Employee> emps) ;
	public List<Employee> showAllEmployee() ; 
	public Employee findEmployeeById(String id) ; 
	public String updateEmployeeById(String id , double newSalary) ; 
	public List<Employee> showEmployeeBySalaryRange(double startSalary , double endSalary) ; 
	public List<Employee> showEmployeeByEname(String... enames) ; 
}
