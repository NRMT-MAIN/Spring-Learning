package com.example.springdatajpademo.service;

import com.example.springdatajpademo.entitty.Customer;
import com.example.springdatajpademo.repository.ICustomerRepository;

import java.util.List;
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
    
    @Override
    public String adjustCustomerBillAmount(int id, float discountPercentage) {
    	Optional<Customer> opt = custRepo.findById(id) ; 
    	
    	if(opt.isPresent()) {
    		Customer cust = opt.get() ; 
    		float discount = cust.getBillAmt() * (discountPercentage / 100.0f) ; 
    		//set final billAmt to Customer
    		cust.setBillAmt(cust.getBillAmt() - discount) ; 
    		custRepo.save(cust) ; 
    		return id + " Customer details are updated" ; 
    	}
    	return id + " Customer not found!";
    }
    
    @Override
    public String registerAndUpdateCustomer(Customer customer) {
    	// get the customer detail on the 
    	Optional<Customer> opt = custRepo.findById(customer.getCno()) ; 
    	
    	if(opt.isPresent()) {
    		custRepo.save(customer) ; 
    		return customer.getCno() + " id details are updated" ; 
    	} else { 
    		int idVal = custRepo.save(customer).getCno() ; 
    		return "Customer Details are inserted with the id value :: " + idVal ; 
    	}
    }
    
    @Override
    public String removeCustomerById(int id) {
    	Optional<Customer> opt = custRepo.findById(id) ; 
    	
    	if(opt.isPresent()) {
    		custRepo.deleteById(id);
    		return id + " Customer is found and deleted" ; 
    	} else {
    		return id + " Customer is not found and deleted" ; 
    	}
    }
    
    @Override
    public String deleteCustomer(Customer customer) {
    	Optional<Customer> opt = custRepo.findById(customer.getCno()) ; 
    	
    	if(opt.isPresent()) {
    		custRepo.delete(customer);
    		return "Csutomer found and deleted" ; 
    	} else {
    		return "Customer not found and deleted" ; 
    	}
    }
    
    
    @Override
    public String deleteAllCustomer() {
    	long count = custRepo.count() ; 
    	if(count > 0) {
    		custRepo.deleteAll();
    		return count + " no of customers are deleted" ; 
    	}
    	return "No records are found and deleted" ; 
    	
    }
    
    @Override
    public String removeAllCustomersById(List<Integer> ids) {
    	List<Customer> list = (List<Customer>) custRepo.findAllById(ids) ;
    	
    	if(ids.size() == list.size()) {
    		custRepo.deleteAllById(ids);
    		return ids + "no of records are deleted" ; 
    	}
    	return "No records are deleted" ; 
    	
    }
}
