package com.example.demo.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.ICustomerManagementService;

@Component
public class PAndSRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerManagementService custService ; 
	
	@Override
	public void run(String... args) throws Exception {
		custService.getAllCustomers(true, "billAmt").forEach(System.out::println);
		
	}
} 
