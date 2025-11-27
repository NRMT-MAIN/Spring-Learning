package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/bank") 
public class BankOperationController {

    @GetMapping("/offers")
    public ResponseEntity<Map<String, Object>> showOffers() { 
        return new ResponseEntity<>(
            Map.of("message", "Bank Offers API", "home_roi", 7.0, "car_roi", 8.0),
            HttpStatus.OK);
    }
    
    @GetMapping("/balance")
    public ResponseEntity<Map<String, Object>> checkBalnace() { 
        int balance = new Random().nextInt(100000);
        return new ResponseEntity<>(
            Map.of("message", "Account Balance Check (CUSTOMER/MANAGER Role)", "balance", balance), 
            HttpStatus.OK);
    }
    
    @GetMapping("/loanApprove")
    public ResponseEntity<String> approveLoan() {
        return new ResponseEntity<>("Loan Approved by Manager (MANAGER Role)", HttpStatus.OK);
    }

    @GetMapping("/denied")
    public ResponseEntity<String> accessDenied() { 
        return new ResponseEntity<>("Error: 403 Forbidden. Role permission denied.", HttpStatus.FORBIDDEN);
    }
}