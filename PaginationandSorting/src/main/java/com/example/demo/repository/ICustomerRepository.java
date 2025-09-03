package com.example.demo.repository ;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entitty.Customer;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer>
 , CrudRepository<Customer , Integer>{
    
}
