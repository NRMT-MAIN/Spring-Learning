package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessagesOperationController {
	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage() {
		return new ResponseEntity<String>("Good Morning" , HttpStatus.OK) ; 
	}
}
