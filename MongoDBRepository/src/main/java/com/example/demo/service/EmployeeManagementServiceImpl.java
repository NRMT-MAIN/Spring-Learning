package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {
	
	@Autowired
	private IEmployeeRepository empRepo ; 
	
	@Override
	public String registerEmployee(Employee emp) {
		String idVal = empRepo.save(emp).getId() ; 
		
		return "Employee is registered with id value :: " + idVal ; 
	}
	
	@Override
	public String[] registerEmployees(List<Employee> emps) {
		List<Employee> semps =  empRepo.saveAll(emps) ; 
		
		String idVal[] = new String[emps.size()] ; 
		
		for(int i = 0 ; i < idVal.length ; i++) {
			idVal[i] = semps.get(i).getId() ; 
		}
		
		return idVal;
	}
	
	@Override
	public List<Employee> showAllEmployee() {
		return empRepo.findAll() ; 
	}
	
	@Override
	public Employee findEmployeeById(String id) {
		Optional<Employee> opt = empRepo.findById(id) ; 
		
		if(opt.isPresent()) 
			return opt.get() ; 
		else 
			throw new IllegalArgumentException("Invalid Id") ; 
	}
	
	@Override
	public String updateEmployeeById(String id, double newSalary) {
		Optional<Employee> opt = empRepo.findById(id) ; 
		
		if(opt.isPresent()) {
			Employee emp = opt.get() ; 
			emp.setEsal(newSalary); 
			
			String idVal = empRepo.save(emp).getId() ; 
			return idVal + " :: Employee with new salary updated!!" ; 
		}
		return id + " document not found!" ; 
		
	}
	
	@Override
	public List<Employee> showEmployeeBySalaryRange(double startSalary, double endSalary) {
		List<Employee> list = empRepo.findByEsalBetween(startSalary, endSalary) ; 
		
		return list;
	}
	
@Override
	public List<Employee> showEmployeeByEname(String... enames) {
		// TODO Auto-generated method stub
		return empRepo.findByEnameIn(enames) ; 
	}
}
