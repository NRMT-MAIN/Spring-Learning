package com.example.demo.service ; 


import org.springframework.data.domain.Page;

import com.example.demo.entitty.Customer;



public interface ICustomerManagementService {
    public Iterable<Customer> getAllCustomers(boolean ascOrder , String ...properties) ; 
    public Page<Customer> getCustomerByPageNo(int pageNo , int pageSize) ; 
    public Page<Customer> getSortedCustomer(int pageNo , int pageSize , boolean ascOrder , String ...properties) ;
    public void showsCustomerPageByPage(int pageSize) ; 
}
