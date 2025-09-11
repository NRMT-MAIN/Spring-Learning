package com.example.demo.service;


import java.util.List;
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
	
	@Override
	public void saveDataUsingPatient() {
		// Create Doctors
        Doctor doc1 = new Doctor("raja", "physician");
        Doctor doc2 = new Doctor("suresh", "ortho");

        // Create Patients
        Patient pat1 = new Patient("karan", 40, "heart");
        Patient pat2 = new Patient("ramesh", 41, "kidney");
        Patient pat3 = new Patient("ram", 40, "BP");
        Patient pat4 = new Patient("rakesh", 35, "stomach");

        // Establish relationship (Doctor ↔ Patients)
//        doc1.setPatients(Set.of(pat1, pat2));
//        doc2.setPatients(Set.of(pat3, pat4));

        pat1.setDoctors(Set.of(doc1));
        pat2.setDoctors(Set.of(doc1));
        pat3.setDoctors(Set.of(doc1, doc2));
        pat4.setDoctors(Set.of(doc2));

        // Save (Cascade ensures patients are also saved)
        patientRepo.saveAll(Set.of(pat1 , pat2 , pat3 , pat4)) ; 
        
        System.out.println("Patients and thier doctors is saved.");
	}
	
	@Override
	public void LoadDataUsingDoctor() {
		List<Doctor> list =   doctRepo.findAll() ; 
		
		list.forEach(doc -> {
			System.out.println("Parent :: " + doc);
			Set<Patient> patient = doc.getPatients() ; 
			patient.forEach(pat -> {
				System.out.println("Childs :: " + pat);
			}) ; 
			System.out.println("------------------------------------");
		});
	}
	
	@Override
	public void LoadDataUsingPatient() {
		List<Patient> list =  patientRepo.findAll() ; 
		
		list.forEach(pat -> {
			System.out.println("Child :: " + pat);
			Set<Doctor> doctor = pat.getDoctors() ; 
			doctor.forEach(doc -> {
				System.out.println("Parents :: " + doc);
			}) ; 
			System.out.println("------------------------------------");
		});
		
	}
}
