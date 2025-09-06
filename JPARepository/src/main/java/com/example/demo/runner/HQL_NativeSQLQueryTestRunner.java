package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.ICustomerRepository;


@Component
public class HQL_NativeSQLQueryTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerRepository custRepo ; 

	@Override
	public void run(String... args) throws Exception {
		int count = custRepo.insertCustomer("Nirmit_Sahu", "Pune", 1100.0) ; 
		
		if(count == 0) {
			System.out.println("Records are not inserted");
		} else {
			System.out.println("Record is inserted");
		}
	}

}
