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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTM_PATIENT")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
	@Id
	@SequenceGenerator(name="gen1" ,sequenceName = "pid_seq",  initialValue = 1000 , allocationSize = 1 )
	@GeneratedValue(generator = "gen1" , strategy = GenerationType.SEQUENCE)
	private Integer pid ; 
	
	@Column(length = 20)
	@NonNull
	private String pname ; 
	
	@NonNull
	private Integer age ; 
	
	@Column(length = 20)
	@NonNull
	private String problem ; 
	
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", age=" + age + ", problem=" + problem + "]";
	}

	@ManyToMany(
		targetEntity = Doctor.class , 
		fetch = FetchType.LAZY , 
		cascade = CascadeType.ALL
	)
	@JoinTable(name= "DOCTORS_PATIENTS" , inverseJoinColumns = @JoinColumn(name = "doctor_id" , referencedColumnName = "did") ,
    joinColumns = @JoinColumn(name="patient_id" , referencedColumnName = "pid"))
	private Set<Doctor> doctors ; 
}
