package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "AM_DLicense")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class DrivingLicense {
	@Id
	private String id ; 
	
	@NonNull
	private String type; 
	
	@NonNull
	private LocalDate validFrom ; 

	@NonNull
	private LocalDate validTo ; 
	
	private Person personDetails ; 
	
	
	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", type=" + type + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ "]";
	}
}
