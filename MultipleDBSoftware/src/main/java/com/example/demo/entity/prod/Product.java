package com.example.demo.entity.prod;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "JPA_ORA_PRODUCT_TAB")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid ; 
	
	 @NonNull
	 @Column(length = 20)
	 private String pname;

	 @NonNull
	 private Double qty;

	 @NonNull
	 private Double price;
}
