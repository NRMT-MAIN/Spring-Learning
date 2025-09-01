package com.example.springdatajpademo.service;

import com.example.springdatajpademo.entitty.Customer;

public interface ICustomerManagementService {
    public String registerCustomer(Customer cust) ; 
    public String showCustomerById(int id) ; 
    public Customer findCustomerById(int id) ; 
    public Customer fetchCustomerById(int id) ; 
}
