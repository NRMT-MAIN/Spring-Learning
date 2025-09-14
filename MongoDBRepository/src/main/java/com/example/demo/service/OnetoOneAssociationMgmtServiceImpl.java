package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DrivingLicense;
import com.example.demo.entity.Person;
import com.example.demo.repository.IDrivingLicenseRepository;
import com.example.demo.repository.IPersonRepository;

@Service("oneToOneService")
public class OnetoOneAssociationMgmtServiceImpl implements IOnetoOneAssociationMgmtService {
	@Autowired
	private IDrivingLicenseRepository dlRepo ; 
	
	@Autowired
	private IPersonRepository personRepo ; 
	
	@Override
	public String saveDataUsingDrivingLicense(DrivingLicense license) {
		String idVal = dlRepo.save(license).getId()  ; 
		return "License obj and its associated person object with id :: " + idVal ;
	}
	
	 @Override
	public String saveDataUsingPerson(Person person) {
		 String idVal = personRepo.save(person).getId()  ; 
		return "Person obj and its associated driving license object with id :: " + idVal ;
	}
	 
	 @Override
	public List<DrivingLicense> showDataUsingDrivingLicenses() {
		return dlRepo.findAll() ; 
	}
	 
	 @Override
	public List<Person> showDataUsingPerson() {
		return personRepo.findAll() ; 
	}
}
