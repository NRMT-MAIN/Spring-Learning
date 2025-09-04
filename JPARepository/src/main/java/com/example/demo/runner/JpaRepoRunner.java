package com.example.demo.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entitty.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerManagementService;

@Component
public class JpaRepoRunner implements CommandLineRunner {
	@Autowired
	private ICustomerManagementService custService ; 
	
	@Autowired
	private ICustomerRepository custRepo ; 
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//			String message = custService.deleteCustomerByIds(List.of(1,2,3,4 , 786)) ; 
//			System.out.println(message);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Customer cust = custService.getCustomerById(34) ; 
//			System.out.println(cust == null ? "Customer not found" : cust);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
//		try {
//			Customer cust = new Customer() ; 
//			cust.setCadd("Delhi") ; 
//			
//			List<Customer> list = custService.showCustomerByExampleData(cust, true, "billAmt" , "cname") ; 
//			list.forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Customer cust1 = new Customer("Ramesh" , "Hyderabad" , 6700.00f) ; 
//			Customer cust2 = new Customer("Ram" , "Hyderabad" , 6450.00f) ; 
//			Customer cust3 = new Customer("Sanjay" , "Mumbai" , 6700.00f) ; 
//			
//			
//			List<Customer> list = List.of(cust1 , cust2 , cust3) ; 
//			
//			System.out.println(custService.groupCustomerRegistration(list));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			//custRepo.findByCnameEquals("Ram").forEach(System.out::println); ; 
			
			//custRepo.findByCaddStartingWith("Hyd").forEach(System.out::println); ; 
			
			custRepo.findByBillAmtBetween(1000.00f, 1200.00f).forEach(System.out::println); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
