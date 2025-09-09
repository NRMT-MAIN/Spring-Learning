package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PhoneNumber;

public interface IPhoneNumberRpository extends JpaRepository<PhoneNumber, Integer> {

}
