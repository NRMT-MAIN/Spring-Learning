package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "AM_PERSON")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Id
	private String id ; 
	
	@NonNull
	private String pname ; 
	
	@NonNull
	private String paddr ; 
	
	@NonNull
	private Integer page ; 
	
	private DrivingLicense licenseDetails ;

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", paddr=" + paddr + ", page=" + page + "]";
	} 
	
}
