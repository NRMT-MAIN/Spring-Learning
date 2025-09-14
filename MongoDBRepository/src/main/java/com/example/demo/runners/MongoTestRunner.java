package com.example.demo.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeManagementService;

@Component
public class MongoTestRunner implements CommandLineRunner {
	
	@Autowired
	private IEmployeeManagementService empService ; 
	
	@Override
	public void run(String... args) throws Exception {
//		Employee emp = new Employee(111, "Nirmit", 10000.00, "Pune", true) ; 
//		
//		String msg = empService.registerEmployee(emp) ; 
//		
//		System.out.println(msg);
		
//		Employee emp1 = new Employee(222, "Ram", 20000.00, "Delhi", true) ;
//		Employee emp2 = new Employee(333, "Laxman", 30000.00, "Pune", false) ;
//		Employee emp3 = new Employee(444, "Hanuman", 40000.00, "Ayodha", true) ;
//		
//		String idVal[] = empService.registerEmployees(List.of(emp1 , emp2 , emp3)) ; 
//		
//		System.out.println("Saved id's docs value are : " + Arrays.toString(idVal));
		
		try {
			//empService.showAllEmployee().forEach(System.out::println);
			
//			Employee emp = empService.findEmployeeById("68c656c83252b2bf3281337a") ; 
//			System.out.println(emp);
			
			String msg = empService.updateEmployeeById("68c656c83252b2bf3281337a", 45000.00) ; 
			System.out.println(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
