package com.example.springdatajpademo.service;

import com.example.springdatajpademo.entitty.Customer;
import com.example.springdatajpademo.repository.ICustomerRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("custService")
public class CustomerManagementServiceImpl implements ICustomerManagementService {
    
    @Autowired
    private ICustomerRepository custRepo ;

    @Override
    public String registerCustomer(Customer cust) {
        Customer cust1 = custRepo.save(cust) ; 
        //cust will not have id value but cust1 will have generated Id value
        System.out.println("Cust1 obj : " + cust1);
        return "Customer obj is saved (record inserted) having the Id value : " + cust1.getCno() ; 
    }
    
    @Override
    public String showCustomerById(int id) {
	    	Optional<Customer> opt = custRepo.findById(id) ; 
	    	if(opt.isPresent()) 
	    		return id+" Customer Details are :: " + opt.get().toString() ; 
	    	return id+ " Customer Not Found" ; 
    }
    
//    @Override
//    public Customer findCustomerById(int id) {
//	    	Optional<Customer> opt = custRepo.findById(id) ; 
//	    	
//	    	if(opt.isPresent())
//	    		return opt.get() ; 
//	    	else throw new IllegalArgumentException("Customer Not Found!") ; 
//    }
    
    
    @Override
    public Customer findCustomerById(int id) {
    	return custRepo.findById(id)
    			.orElseThrow(() -> new IllegalArgumentException("Customer Not Found")) ; 
    }

    @Override
    public Customer fetchCustomerById(int id) {
    	return custRepo.findById(id).orElse(new Customer()) ; 
    }
    
}
