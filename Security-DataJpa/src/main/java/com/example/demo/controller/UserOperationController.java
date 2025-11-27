package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserDetails;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserOperationController {
	@Autowired
	private IUserService service ;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDetails details) {
		String msg = service.registerUser(details) ; 
		return new ResponseEntity<String>(msg , HttpStatus.CREATED) ; 
	}
	
	@GetMapping("/")
    public ResponseEntity<String> showHome() {
        return new ResponseEntity<>("Welcome to the Bank REST Service (Public Home)", HttpStatus.OK);
    }
}
