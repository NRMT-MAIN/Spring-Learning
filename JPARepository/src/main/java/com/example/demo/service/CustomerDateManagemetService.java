package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitty.CustomerDate;
import com.example.demo.repository.ICustomerDateRepository;

@Service("custDateService")
public class CustomerDateManagemetService implements ICustomerDateManagementService {
	
	@Autowired
	private ICustomerDateRepository custRepo ;
	
	@Override
	public String registerCustomer(CustomerDate cust) {
		int idVal = custRepo.save(cust).getCid() ; 
		
		return "Customer is saved with the id value :: " + idVal ; 
	}
	
	@Override
	public List<CustomerDate> getAllCustomers() {
		return custRepo.findAll() ; 
	}
}
