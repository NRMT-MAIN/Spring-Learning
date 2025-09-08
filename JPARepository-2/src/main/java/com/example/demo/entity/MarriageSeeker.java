package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "MARRIAGE_TAB")
@NoArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker implements Serializable {

	@Id
	@Column(name = "MID")
	@GeneratedValue
	private Long mid ;
	
	@Column(length=20)
	@NonNull
	private String name ; 
	
	@Column(length=20)
	@NonNull
	private String addrss ;
	
	@NonNull
	private LocalDateTime dob ; 
	
	@Lob
	@NonNull
	private byte[] photo ; 
	
	@Lob
	@NonNull
	private char[] resume ; 
	
	@NonNull
	private boolean indian ; 
}
