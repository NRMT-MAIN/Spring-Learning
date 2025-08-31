package com.example.springdatajpademo.runners;

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
        Customer cust = new Customer() ;
        cust.setCname("John Doe");
        cust.setCaddrs("123 Main St");
        cust.setBillAmt(100.0f);

        String msg = custService.registerCustomer(cust) ; 
        System.out.println(msg);

    }

}
