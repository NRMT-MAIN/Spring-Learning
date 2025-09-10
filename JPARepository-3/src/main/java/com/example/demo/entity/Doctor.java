package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTM_DOCTOR")
@Getter
@Setter
@RequiredArgsConstructor
public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer did ; 
	
	@Column(length=20)
	@NonNull
	private String dname ; 
	
	@Column(length=20)
	@NonNull
	private String specialization ; 
	
	@ManyToMany(
		targetEntity = Patient.class , 
		cascade = CascadeType.ALL , 
		fetch = FetchType.LAZY
	)
	@JoinTable(name= "DOCTORS_PATIENTS" , joinColumns = @JoinColumn(name = "doctor_id" , referencedColumnName = "did") ,
	           inverseJoinColumns = @JoinColumn(name="patient_id" , referencedColumnName = "pid"))
	private Set<Patient> patients ; 
	
	public Doctor() {
		System.out.println("Doctor :: 0 Args Constructor");
	}
}
