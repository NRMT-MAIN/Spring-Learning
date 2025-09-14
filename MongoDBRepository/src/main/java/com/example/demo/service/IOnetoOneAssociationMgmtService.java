package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DrivingLicense;
import com.example.demo.entity.Person;

public interface IOnetoOneAssociationMgmtService {
	public String saveDataUsingPerson(Person persong) ; 
	public String saveDataUsingDrivingLicense(DrivingLicense license) ; 
	public List<Person> showDataUsingPerson() ; 
	public List<DrivingLicense> showDataUsingDrivingLicenses() ; 
}
