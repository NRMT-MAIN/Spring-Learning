package com.example.demo.repository ;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitty.Customer;
import com.example.demo.view.IDynamicResultView;
import com.example.demo.view.IResultView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	public List<Customer> findByCnameEquals(String name) ; 
	public List<Customer> findByCaddStartingWith(String addr) ; 
	//public List<Customer> findByBillAmtBetween(float startAmount , float endAmount) ; 
	public List<Customer> findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(float startAmt , float endAmt) ;
	public List<Customer> findByCaddInIgnoreCaseOrCnameContainingIgnoreCase(List<String> adrwsses , String nameChar) ;
	public List<Customer> findByCaddInIgnoreCaseAndCnameContainingIgnoreCase(List<String> adrwsses , String nameChar) ;
	
	//Scalar Operation
	public List<IResultView> findByBillAmtBetween(float startAmt , float endAmt) ; 

	public <T extends IDynamicResultView> List<T> findByCaddIn(List<String> addresses , Class<T> clazz) ; 
	
	public Customer findByCid(int cid) ;  
}
