package com.example.demo.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeManagementService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeManagementService service ; 
	
	@Override
	public void run(String... args) throws Exception {
//		Employee emp = new Employee(111, "Nirmit Sahu", 5000.00, "Pune") ; 
//		String msg = service.registerEmployee(emp) ;
//		
//		System.out.println(msg);
		
		Employee emp1 = new Employee(222, "Nirmit Sahu", 5000.00, "Pune");
		Employee emp2 = new Employee(223, "Aarav Mehta", 6200.50, "Mumbai");
		Employee emp3 = new Employee(224, "Isha Verma", 7100.75, "Bangalore");

		String msg = service.registerBatchEmployee(List.of(emp1 , emp2 , emp3)) ;
		System.out.println(msg) ;
		
	}
}
