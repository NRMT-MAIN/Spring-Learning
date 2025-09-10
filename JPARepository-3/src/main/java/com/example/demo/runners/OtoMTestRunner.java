package com.example.demo.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.I1toMOperationService;

//@Component
public class OtoMTestRunner implements CommandLineRunner {
	@Autowired
	private I1toMOperationService service ; 

	@Override
	public void run(String... args) throws Exception {
		//service.saveDataUsingCustomer();
		//service.saveDataUsingPhoneNumber();
		
		service.getDataUsingCustomer();
	}

}
