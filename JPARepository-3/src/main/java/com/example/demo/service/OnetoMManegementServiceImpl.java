package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.IPhoneNumberRpository;

@Service("oneToMService")
public class OnetoMManegementServiceImpl implements I1toMOperationService {
	@Autowired
	private ICustomerRepository custRepo ; 
	
	@Autowired
	private IPhoneNumberRpository phoneRepo ; 

	@Override
	public void saveDataUsingCustomer() {
		//Prepare Data
		Customer cust = new Customer("Nirmit", "Pune") ; 
		
		PhoneNumber phoneNo1 = new PhoneNumber(99999999L, "Office_Number", "Airtel")  ; 
		PhoneNumber phoneNo2 = new PhoneNumber(99999229L, "Residence_Number", "VI")  ; 
		
		//Linked child to parent or vice versa
		Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>() ; 
		phoneSet.add(phoneNo1) ; 
		phoneSet.add(phoneNo2) ; 
		
		//Parents are linked with child
		phoneNo1.setCustomer(cust);
		phoneNo2.setCustomer(cust);
		
		//childs are linked with parents
		cust.setPhones(phoneSet);
		
		//save data using pareant object
		int idVal = custRepo.save(cust).getCid() ; 
		
		System.out.println("Customer object and child objects are saved with id value :: " + idVal);
		
	}
	
	
	@Override
	public void saveDataUsingPhoneNumber() {
		//Prepare Data
				Customer cust = new Customer("Anshu", "MP") ; 
				
				PhoneNumber phoneNo1 = new PhoneNumber(99999739L, "Office_Number", "Jio")  ; 
				PhoneNumber phoneNo2 = new PhoneNumber(99344129L, "Residence_Number", "BSNL")  ; 
				
				//Linked child to parent or vice versa
				Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>() ; 
				phoneSet.add(phoneNo1) ; 
				phoneSet.add(phoneNo2) ; 
				
				//Parents are linked with child
				phoneNo1.setCustomer(cust);
				phoneNo2.setCustomer(cust);
				
				//childs are linked with parents
				cust.setPhones(phoneSet);
				
				//save data using pareant object
				int idVal1 = phoneRepo.save(phoneNo1).getRegno() ; 
				int idVal2 = phoneRepo.save(phoneNo2).getRegno() ; 
				
				System.out.println("Phone Number objects and associated parent objects are saved ith :: " + idVal1 + "..." + idVal2);
		
	}
	
	@Override
	public void getDataUsingCustomer() {
		List<Customer> list = custRepo.findAll() ; 
		
		list.forEach(cust -> {
			System.out.println("Parent :: " + cust);
			Set<PhoneNumber> child = cust.getPhones() ; 
			child.forEach(ph -> {
				System.out.println("Child :: " + child);
			}) ; 
		});
		
	}
}
