package com.example.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class MessageRenderController {
	 @GetMapping("/wish") 
	 public ResponseEntity<String> showMessage() {

	        LocalDateTime ldt = LocalDateTime.now();
	        int hour = ldt.getHour();
	        String msg = null;

	        if (hour < 12)
	            msg = "Good Morning";
	        else if (hour < 16)
	            msg = "Good Afternoon";
	        else if (hour < 20)
	            msg = "Good Eveing";
	        else
	            msg = "Good Night";

	        ResponseEntity<String> entity = new ResponseEntity<>(msg, HttpStatus.OK);
	        
	        return entity;
	 } 
}
