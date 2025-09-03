package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitty.Customer;
import com.example.demo.repository.ICustomerRepository;

@Service
public class CustomerServiceManagementImpl implements ICustomerManagementService {
	
	@Autowired
	private ICustomerRepository custRepo; 
	
	@Override
	public String deleteCustomerByIds(List<Integer> ids) {
		List<Customer> list = custRepo.findAllById(ids) ;
		
		if(list.size() != 0) {
			custRepo.deleteAllByIdInBatch(ids);
			return list.size() + " records are deleted!" ; 
		}
		
		return "No records found for deletion" ; 
	}
	
	@Override
	public Customer getCustomerById(int id) {
		//Customer cust = custRepo.getById(id) ; --> deprecated
		//Customer cust = custRepo.getOne(id) ; ---> deprecated
		
		Customer cust = custRepo.getReferenceById(id) ; // ---> latest
		return cust ; 
	}
}
