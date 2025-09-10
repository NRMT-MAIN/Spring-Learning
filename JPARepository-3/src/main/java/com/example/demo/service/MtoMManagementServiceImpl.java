package com.example.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.IDoctorRepository;
import com.example.demo.repository.IPatientRepository;

@Service("mtomService")
public class MtoMManagementServiceImpl implements IMToMManagementService {
	@Autowired
	private IDoctorRepository doctRepo ; 
	
	@Autowired 
	private IPatientRepository patientRepo ; 
	
	@Override
	public void saveDataUsingDoctor() {
		Doctor doc1 = new Doctor("Nirmit" , "Physician") ;
		Doctor doc2 = new Doctor("Pooja" , "Surgean") ;
		
		Patient pt1 = new Patient("Raja", 20, "Heart Attack") ; 
		Patient pt2 = new Patient("Rajesh", 40, "Kidney Attack") ; 
		Patient pt3 = new Patient("Ram", 50, "Brain Problem") ; 
		
		//Add patient to doctor ; 
		doc1.setPatients(Set.of(pt1 , pt2 , pt3));
		doc2.setPatients(Set.of(pt2 , pt3));
		
		
		doctRepo.saveAll(Set.of(doc1 , doc2)) ; 
		
		System.out.println("Doctor and patients are saved");
		
	}
}
