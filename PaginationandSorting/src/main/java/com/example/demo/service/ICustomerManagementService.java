package com.example.demo.service ; 


import com.example.demo.entitty.Customer;



public interface ICustomerManagementService {
    public Iterable<Customer> getAllCustomers(boolean ascOrder , String ...properties) ; 
}
