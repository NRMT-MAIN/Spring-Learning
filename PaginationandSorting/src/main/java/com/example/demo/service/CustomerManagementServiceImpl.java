package com.example.demo.service ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entitty.Customer;
import com.example.demo.repository.ICustomerRepository;

@Service("custService")
public class CustomerManagementServiceImpl implements ICustomerManagementService {
    
    @Autowired
    private ICustomerRepository custRepo ;

    @Override
    public Iterable<Customer> getAllCustomers(boolean ascOrder, String... properties) {
    	Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC , properties) ; 
    	
    	Iterable<Customer> it = custRepo.findAll(sort) ; 
    	return it ; 
    }
}
