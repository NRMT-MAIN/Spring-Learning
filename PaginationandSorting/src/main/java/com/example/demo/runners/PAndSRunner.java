package com.example.demo.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.demo.entitty.Customer;
import com.example.demo.service.ICustomerManagementService;

@Component
public class PAndSRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerManagementService custService ; 
	
	@Override
	public void run(String... args) throws Exception {
		//custService.getAllCustomers(true, "billAmt").forEach(System.out::println);
		
		//Page<Customer> page = custService.getCustomerByPageNo(2, 4) ; 
		
//		Page<Customer> page = custService.getSortedCustomer(2, 5, true, "billAmt" , "cadd") ; 
//		System.out.println("Requested Page Request are :: ");
//		page.getContent().forEach(System.out::println);
//		System.out.println("Page number ::"+page.getNumber());
//		System.out.println("Total pages count ::"+page.getTotalPages());
//		System.out.println("Is it first page ::"+page.isFirst());
//		System.out.println("Is it last page ::"+page.isLast());
//		System.out.println("Page Size::"+page.getSize());
//		System.out.println("Records in Requested Page ::" + page.getNumberOfElements());
		
		custService.showsCustomerPageByPage(3);
	}
} 
