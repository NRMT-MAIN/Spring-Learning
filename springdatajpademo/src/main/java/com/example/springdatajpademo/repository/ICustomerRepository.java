package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entitty.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
    
}
