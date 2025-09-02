package com.example.springdatajpademo.service;

import java.util.List;

import com.example.springdatajpademo.entitty.Customer;

public interface ICustomerManagementService {
    public String registerCustomer(Customer cust) ; 
    public String showCustomerById(int id) ; 
    public Customer findCustomerById(int id) ; 
    public Customer fetchCustomerById(int id) ; 
    public String adjustCustomerBillAmount(int id , float discountPercentage) ;
    public String registerAndUpdateCustomer(Customer customer) ; 
    public String removeCustomerById(int id) ; 
    public String deleteCustomer(Customer customer) ; 
    public String deleteAllCustomer() ; 
    public String removeAllCustomersById(List<Integer> ids) ; 
}
