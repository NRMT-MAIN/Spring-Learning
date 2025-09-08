package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount, Long> {

}
