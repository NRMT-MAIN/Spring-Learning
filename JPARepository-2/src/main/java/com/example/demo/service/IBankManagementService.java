package com.example.demo.service;

import com.example.demo.entity.BankAccount;

public interface IBankManagementService {
	public String createBankAcount(BankAccount acc) ; 
	public String updateAccountMobileNo(Long accNo , Long newMobileNo) ; 
}
