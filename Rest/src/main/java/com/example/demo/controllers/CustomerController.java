package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer") 
public class CustomerController {
	 @GetMapping("/report") 
	 public ResponseEntity<String> showCustomersReport() {
	     return new ResponseEntity<>("From GET-ShowReport Method (READ Operation)", HttpStatus.OK); 
	 }
	
	 @PostMapping("/register")
	 public ResponseEntity<String> registerCustomer() {
	     return new ResponseEntity<>("From POST-RegisterCustomer Method (CREATE Operation)", HttpStatus.CREATED); 
	 }
	

	 @PutMapping("/modify")
	 public ResponseEntity<String> updateCustomer() {
	     return new ResponseEntity<>("From PUT-UpdateCustomer() Method (FULL UPDATE Operation)", HttpStatus.OK); 
	 }


	 @PatchMapping("/pmodify")
	 public ResponseEntity<String> updateCustomerByNo() {
	     return new ResponseEntity<>("From PATCH-UpdateCustomerByNo() Method (PARTIAL UPDATE Operation)", HttpStatus.OK); 
	 }
	
	 @DeleteMapping("/delete")
	 public ResponseEntity<String> deleteCustomer() {
	     return new ResponseEntity<>("From DELETE-deleteCustomer Method (DELETE Operation)", HttpStatus.NO_CONTENT); 
	 }
}
