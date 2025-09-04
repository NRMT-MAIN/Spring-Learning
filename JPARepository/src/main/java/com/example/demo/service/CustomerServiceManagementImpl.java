package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	@Override
	public List<Customer> showCustomerByExampleData(Customer cust, boolean ascOrder, String... properties) {
		//Prepare Example Object having the Customer Object
		Example<Customer> example = Example.of(cust) ; 
		
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC , properties) ;
		
		List<Customer> list = custRepo.findAll(example , sort) ; 
		
		return list ; 
	}
	
	@Override
	public String groupCustomerRegistration(List<Customer> list) {
		custRepo.saveAllAndFlush(list) ; 
		
		return list.size() + " no. of records are saved!" ; 
	}
}
