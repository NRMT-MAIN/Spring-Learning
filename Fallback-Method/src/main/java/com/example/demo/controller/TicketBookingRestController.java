package com.example.demo.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {

    @GetMapping("/book")
    @CircuitBreaker(name = "TicketService" , fallbackMethod = "dummyBookTicket")
    public String bookTicket() {
        System.out.println("TicketBookingRestController.bookTicket() - Attempting logic.");

        if (new Random().nextInt(10) < 5) {
            System.out.println("--- ACTUAL METHOD FAILING ---");
            throw new RuntimeException("Problem in b.logic");
        }

        return "SUCCESS: Output from business logic.";
    }


    public String dummyBookTicket() {
        System.out.println("TicketBookingRestController.dummyBookTicket() - Providing fallback.");
        
        return "Place Try later -- Inconvenience is regratted. (Service Down)";
    }
}