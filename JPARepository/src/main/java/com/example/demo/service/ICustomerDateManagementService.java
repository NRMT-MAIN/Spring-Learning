package com.example.demo.service;

import java.util.List;

import com.example.demo.entitty.CustomerDate;

public interface ICustomerDateManagementService {
	public String registerCustomer(CustomerDate cust) ; 
	public List<CustomerDate> getAllCustomers() ; 
}
