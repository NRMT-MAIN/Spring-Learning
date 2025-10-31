package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tourist;
import com.example.demo.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationController {
	@Autowired
	private ITouristMgmtService service ; 
	
	@PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        try {
            String resultMsg = service.registerTourist(tourist);
            
            return new ResponseEntity<>(resultMsg, HttpStatus.CREATED); 
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Problem in tourist enrollment: " + e.getMessage(), 
                                        HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
}
