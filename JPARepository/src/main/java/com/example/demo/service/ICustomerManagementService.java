package com.example.demo.service;

import java.util.List;


import com.example.demo.entitty.Customer;

public interface ICustomerManagementService {
	public String deleteCustomerByIds(List<Integer> ids) ; 
	public Customer getCustomerById(int id) ; 
	public List<Customer> showCustomerByExampleData(Customer cust, boolean ascOrder , String ...properties) ; 
	public String groupCustomerRegistration(List<Customer> list) ; 
}
