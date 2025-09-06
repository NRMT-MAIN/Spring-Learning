package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.ICustomerRepository;

//@Component
public class HQL_NonSelectQueryTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerRepository custRepo ; 

	@Override
	public void run(String... args) throws Exception {
//		int count = custRepo.updateCustomerBillAmtByAddresses(10.0, "Hyderabad", "Delhi") ; 
//		System.out.println("Number of customer are affected :: " + count);
		
		int count  = custRepo.deleteCustomerByBillAmtRange(1000.0 , 1200.0) ; 
		System.out.println("Number of customers are deleted :: " + count);
	}

}
