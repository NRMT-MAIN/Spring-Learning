package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entitty.Customer;
import com.example.demo.service.ICustomerManagementService;

@Component
public class JpaRepoRunner implements CommandLineRunner {
	@Autowired
	private ICustomerManagementService custService ; 
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//			String message = custService.deleteCustomerByIds(List.of(1,2,3,4 , 786)) ; 
//			System.out.println(message);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Customer cust = custService.getCustomerById(34) ; 
			System.out.println(cust == null ? "Customer not found" : cust);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
