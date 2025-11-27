package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.UserDetails;

public interface IUserService extends UserDetailsService {
	public String registerUser(UserDetails details) ; 
}
