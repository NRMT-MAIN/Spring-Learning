package com.example.demo.repository ;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitty.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	public List<Customer> findByCnameEquals(String name) ; 
	public List<Customer> findByCaddStartingWith(String addr) ; 
	public List<Customer> findByBillAmtBetween(float startAmount , float endAmount) ; 
}
