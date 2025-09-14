package com.example.demo.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "Employee_SpecialTypes")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	@Id
	private String id ; 
	
	@NonNull
	private Integer eno ; 
	
	@NonNull
	private String ename ; 
	
	@NonNull
	private double esal ; 
	
	@NonNull
	private String eaddr ; 
	
	@NonNull
	private boolean isVaccinated ; 
	
	@NonNull
	private List<String> friends ; 
	
	@NonNull
	private Set<Long> phoneNumbers ; 
	
	@NonNull
	private Properties idDetails ;
	
	@NonNull
	private Map<Integer , String> insurancePolicies ; 
	
}
