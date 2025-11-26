package com.example.demo.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankOperationController {

    @GetMapping("/")
    public ResponseEntity<String> showHome() { 
        return new ResponseEntity<>("Welcome to Xyz Bank REST API - Home Page (Public)", HttpStatus.OK);
    }

    @GetMapping("/offers")
    public ResponseEntity<String> showOffers() { 
        String offers = "Home Loan ROI: 7%, Car Loan ROI: 8%";
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/balance")
    public ResponseEntity<Map<String, Object>> checkBalnace() { 
        int balance = new Random().nextInt(100000);
        return new ResponseEntity<>(
            Map.of("message", "Account Balance Check", "balance", balance), 
            HttpStatus.OK);
    }

    @GetMapping("/loanApprove")
    public ResponseEntity<String> approveLoan() {
        return new ResponseEntity<>("Loan Approved (MANAGER Access Only)", HttpStatus.OK);
    }


    @GetMapping("/denied")
    public ResponseEntity<String> accessDenied() { 
        return new ResponseEntity<>("Error: 403 Forbidden - Insufficient Role Access.", HttpStatus.FORBIDDEN);
    }
}