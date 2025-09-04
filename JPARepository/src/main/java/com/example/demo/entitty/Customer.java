package com.example.demo.entitty ;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="JPA_CUSTOMER_TAB")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public Customer(String cname, String cadd, float billAmt) {
		this.cname = cname ; 
		this.cadd = cadd ; 
		this.billAmt = billAmt ; 
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Integer cid;

    
    @NonNull
    private String cname ; 
    
    @NonNull
    private String cadd ; 
    
    @NonNull
    private Float billAmt ; 
}