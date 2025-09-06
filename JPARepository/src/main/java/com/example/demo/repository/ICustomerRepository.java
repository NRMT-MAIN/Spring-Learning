package com.example.demo.repository ;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entitty.Customer;
import com.example.demo.view.IDynamicResultView;
import com.example.demo.view.IResultView;

import jakarta.transaction.Transactional;

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
	
	//Query Methods
	
	@Query("from Customer")
	public List<Customer> getAllCustomer() ;
	
	//@Query("from Customer where billAmt between ?1 and ?2 ")
	@Query("from Customer where billAmt between :start and :end ")
	public Iterable<Customer> getCustomerByBillAmountRange(@Param("start") float startAmt ,@Param("end") float endAmount) ; 
	
	@Query("select cid , cname , billAmt from Customer where cname in(:name1 , :name2)")
	public List<Object[]> getCustomerData(String name1 , String name2) ; 
	
	@Query("select cadd from Customer where cname like :initChars")
	public List<String> findCustomerAddrsByNameChars(String initChars) ; 
	
	@Query("from Customer where cadd=:addrs")
	public Customer findCustomerDataByAddrs(String addrs) ; 
	
	//Non-Select SQL Queries
	
	@Query("update Customer set billAmt = billAmt + (billAmt * :percentage / 100.0f) where cadd in (:city1 , :city2)")
	@Transactional
	@Modifying
	public int updateCustomerBillAmtByAddresses(double percentage , String city1 , String city2) ; 
	
	@Query("delete from Customer where billAmt between :start and :end")
	@Transactional
	@Modifying
	public int deleteCustomerByBillAmtRange(double start , double end) ; 
	
	
	//Native SQL Query
	@Query(value="INSERT INTO JPA_CUSTOMER_TAB VALUES(CNO_SEQ1.NEXTVAL,:billAmt,:adrres,:name)" , nativeQuery = true)
	@Transactional
	@Modifying
	public int insertCustomer(String name , String adrres , double billAmt) ; 
}
