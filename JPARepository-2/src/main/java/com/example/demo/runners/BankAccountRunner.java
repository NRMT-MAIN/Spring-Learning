package com.example.demo.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.BankAccount;
import com.example.demo.service.IBankManagementService;

//@Component
public class BankAccountRunner implements CommandLineRunner {
	
	@Autowired
	private IBankManagementService bankService ; 

	@Override
	public void run(String... args) throws Exception {
		
		//Save the object
//		try {
//			BankAccount acc = new BankAccount("Anshu" , 900000.0 , 96857452455L) ; 
//			String msg = bankService.createBankAcount(acc) ;
//			System.out.println(msg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//Load and Update the object
		try {
			String msg = bankService.updateAccountMobileNo(10000000L, 9685790244L) ; 
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
