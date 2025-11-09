package com.example.demo.pms;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationServiceController {
	
	@GetMapping("/info")
	public ResponseEntity<String> showBillingInfo() {
		return new ResponseEntity<String>("We accept UPI-Payments, Debit Cards , Credit Cards." , HttpStatus.OK) ; 
	}
}
