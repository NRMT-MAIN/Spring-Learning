package com.example.demo.repository ;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitty.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
    
}
