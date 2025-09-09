package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="JPA_OTM_PHONENUMBER_TAB")
@RequiredArgsConstructor
@NoArgsConstructor
public class PhoneNumber implements Serializable {
	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNo=" + phoneNo + ", numberType=" + numberType + ", provider="
				+ provider + "]";
	}

	@Id
	@SequenceGenerator(name="gen_1" , sequenceName = "REGNO_SEQ" , initialValue = 1000 , allocationSize = 1)
	@GeneratedValue(generator = "gen_1" , strategy = GenerationType.SEQUENCE)
	private Integer regno ; 
	
	@Column(nullable = false , unique = true)
	@NonNull
	private Long phoneNo ; 
	
	@Column(length=20)
	@NonNull
	private String numberType ; 
	
	@Column(length=20)
	@NonNull
	private String provider ; 
	
	@ManyToOne(
		targetEntity = Customer.class , 
		cascade = CascadeType.ALL
	)
	@JoinColumn(
		name = "CUSTOMER_ID" , 
		referencedColumnName = "CID"
	)
	private Customer customer ; 
}
