package com.example.demo.service ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
    @Override
    public Page<Customer> getCustomerByPageNo(int pageNo, int pageSize) {
    	//Prepare Pageable Object
    	Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize) ; 
    	//Get Requested Page Detail
    	Page<Customer> page = custRepo.findAll(pageable) ; 
    	
    	return page ; 
    }
    
    @Override
    public Page<Customer> getSortedCustomer(int pageNo, int pageSize, boolean ascOrder, String... properties) {
    	//Prepare Sort Object
    	Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC , properties) ; 
    	
    	//Prepare Pageable Object
    	Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize , sort) ; 
    	//Get Requested Page Detail
    	Page<Customer> page = custRepo.findAll(pageable) ; 
    	
    	return page ; 
    }
    
    @Override
    public void showsCustomerPageByPage(int pageSize) {
    	// get total records count
    	long count = custRepo.count() ; 
    	
    	//get pages count
    	long pagesCount = count / pageSize ; 
    	
    	pagesCount = (count % pageSize == 0) ? pagesCount : ++pagesCount ; 
    	
    	for(int i = 0 ; i < pagesCount ; i++) {
    		//Prepare the pageable object
    		Pageable pageable = PageRequest.of(i, pageSize) ;
    		Page<Customer> page = custRepo.findAll(pageable) ; 
    		page.forEach(System.out::println);
    		System.out.println("--------------" + (page.getNumber() + 1) + " / " + page.getTotalPages() + "------------");
    	}
    }
}
