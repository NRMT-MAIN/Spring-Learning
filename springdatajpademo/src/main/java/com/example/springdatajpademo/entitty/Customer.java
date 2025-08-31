package com.example.springdatajpademo.entitty;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_CUSTOMER_TAB")
@Data //To get the getter setter method dynamically
public class Customer {
    @Column(name="CID")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) //Generates the value to the cno automatically.
    private Integer cno;
    //Here Value will start with 1.
    
    @Column(name="CNAME" , length=20) //name attribute is optional
    private String cname ; 
    
    @Column(name="CADD" , length=20)
    private String caddrs ; 
    
    @Column(name="BILL_AMT") //@Column optional
    private Float billAmt ; 
}