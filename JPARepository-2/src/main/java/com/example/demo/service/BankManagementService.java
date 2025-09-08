package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BankAccount;
import com.example.demo.respository.IBankAccountRepository;

@Service("bankService")
public class BankManagementService implements IBankManagementService {
	
	@Autowired
	private IBankAccountRepository bankRepo ; 

	@Override
	public String createBankAcount(BankAccount acc) {
		long accNo = bankRepo.save(acc).getAccNo() ; 
		
		return "Bank Account is opened having Account Number :: " + accNo ; 
	}
	
	@Override
	public String updateAccountMobileNo(Long accNo, Long newMobileNo) {
		// Load the object ; 
		Optional<BankAccount> opt = bankRepo.findById(accNo) ; 
		if(opt.isPresent()) {
			BankAccount acc = opt.get() ; 
			
			acc.setMobileNo(newMobileNo);
			bankRepo.save(acc) ; 
			return accNo + " account Number is updated with Mobile Number: " + newMobileNo ; 
		} else {
			return accNo + " account Number is not found!" ; 
		}
	}
}
