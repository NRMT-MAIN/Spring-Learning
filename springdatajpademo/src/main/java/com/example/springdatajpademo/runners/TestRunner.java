package com.example.springdatajpademo.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springdatajpademo.entitty.Customer;
import com.example.springdatajpademo.service.ICustomerManagementService;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private ICustomerManagementService custService ; 

    @Override
    public void run(String... args) throws Exception {
        // Test the customer management service
//        Customer cust = new Customer() ;
//        cust.setCname("John Doe");
//        cust.setCaddrs("123 Main St");
//        cust.setBillAmt(100.0f);
//
//        String msg = custService.registerCustomer(cust) ; 
//        System.out.println(msg);
    	
//    	try {
//			System.out.println(custService.showCustomerById(952));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
    	
    	
//    	try {
//			System.out.println(custService.findCustomerById(952));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

    	
//    	
//    	try {
//			System.out.println(custService.fetchCustomerById(9));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
    	
//    	try {
//			System.out.println(custService.adjustCustomerBillAmount(952, 10.0f));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
    	
    	
//    	try {
//    		Customer customer = new Customer() ; 
//    		customer.setCname("Kartik Aaryan");
//    		customer.setCaddrs("Mumbai");
//    		customer.setBillAmt(1000.00f);
//			System.out.println(custService.registerAndUpdateCustomer(customer));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
    	
//    	try {
//			System.out.println(custService.removeCustomerById(1));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    	
    	
//    	try {
//			Customer customer = new Customer(2 , "Rnadom" , "No" , 100.00f) ; 
//			System.out.println(custService.deleteCustomer(customer));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    	
    	
//    	try {
//			System.out.println(custService.deleteAllCustomer());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    	
    	try {
			System.out.println(custService.removeAllCustomersById(List.of(202)));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
}
