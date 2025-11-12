package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@RefreshScope
public class TestController {
	@Value("${db.username}") 
    private String user;
    
    @Value("${db.pwd}")
    private String pass;

    @GetMapping("/show")
    public String showData() {
        return "Data Collected through Config Server :: User: " + user + " ---- Password: " + pass;
    }
}
