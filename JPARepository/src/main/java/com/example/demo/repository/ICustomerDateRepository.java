package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitty.CustomerDate;

public interface ICustomerDateRepository extends JpaRepository<CustomerDate, Integer> {
	
}
