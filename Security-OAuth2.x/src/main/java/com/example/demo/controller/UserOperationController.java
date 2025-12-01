package com.example.demo.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOperationController {
	// Public endpoint (no login required)
    @GetMapping("/")
    public String publicEndpoint() {
        return "This is a public endpoint. Anyone can access.";
    }

    // Secured endpoint (requires OAuth2 login)
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User user) {
        return "Welcome, " + user.getAttribute("name");
    }

    // Return all OAuth2 user details in JSON
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }

    // Logout success endpoint
    @GetMapping("/logout-success")
    public String logoutPage() {
        return "You are logged out successfully.";
    }
}
