package com.example.demo.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entitty.CustomerDate;
import com.example.demo.service.ICustomerDateManagementService;


@Component
public class CustomerDateRunner implements CommandLineRunner {
	@Autowired
	private ICustomerDateManagementService custService ; 

	@Override
	public void run(String... args) throws Exception {
		
		try {
//			CustomerDate cust = new CustomerDate() ; 
//			cust.setCname("Harsha");
//			cust.setCadd("Bihar");
//			cust.setBillAmt(1100.00f);
//			cust.setDob(LocalDateTime.of(2004,06,26,10,12,20));
//			cust.setDop(LocalDate.now());
//			
//			String msg = custService.registerCustomer(cust) ; 
//			System.out.println(msg);
			
			custService.getAllCustomers().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
