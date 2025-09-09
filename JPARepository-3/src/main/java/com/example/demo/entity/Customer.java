package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_CUSTOMER_TAB")
@Getter
@Setter
@EqualsAndHashCode //@Data disturbs hashcode and equals when entity class are kept in relationship
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid ; 
	
	@NonNull
	@Column(length = 20)
	private String cname ; 
	
	@NonNull
	@Column(length = 20)
	private String caddrs ;
	
	@OneToMany(
		targetEntity = PhoneNumber.class , 
		cascade = CascadeType.ALL , 
		mappedBy = "customer" //child class property  , 
	)
//	@JoinColumn(
//	    name = "CUSTOMER_ID" ,referencedColumnName = "CID"
//	)
	private Set<PhoneNumber> phones ;

	@Override
	public String toString() {
		return "Customer [id=" + cid + ", cname=" + cname + ", caddrs=" + caddrs + "]";
	} 
}
