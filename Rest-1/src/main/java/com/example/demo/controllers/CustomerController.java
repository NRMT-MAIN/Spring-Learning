package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Company;
import com.example.demo.entities.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomerData() {
		 Company comp = new Company("SAMSUNG", "hyd", "Eletronics", 4000);
	     Map<String, Object> ids = Map.of("aadhar", 35345435L, "panNo", 354353534L);
	        
	     Customer cust = new Customer(111, "Nirmit",
	    		 "Pune", 
	    		 1500.0f, 
	    		 new String[] {"green" , "red"},List.of("ECE" , "CSE") ,
	    		 Set.of(8582282888L , 5456415614L), ids, comp) ; 
	        
	    return new ResponseEntity<>(cust, HttpStatus.OK);
	}
}
