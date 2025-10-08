package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="COVIDCASES")
public class CovidCases {
	   @Id 
	   @Column(name="COUNTRY") 
	   private String country; 
	   
	   @Column(name = "CONFIRMED") 
	   private int confirmed; 
	   
	   @Column(name="DEATHS") 
	   private int deaths; 
	   
	   @Column(name="RECOVERED") 
	   private int recovered; 
	 
	   @Column(name="ACTIVE") 
	   private int active;

	   public String getCountry() {
		   return country;
	   }

	   public void setCountry(String country) {
		   this.country = country;
	   }

	   public int getConfirmed() {
		   return confirmed;
	   }

	   public void setConfirmed(int confirmed) {
		   this.confirmed = confirmed;
	   }

	   public int getDeaths() {
		   return deaths;
	   }

	   public void setDeaths(int deaths) {
		   this.deaths = deaths;
	   }

	   public int getRecovered() {
		   return recovered;
	   }

	   public void setRecovered(int recovered) {
		   this.recovered = recovered;
	   }

	   public int getActive() {
		   return active;
	   }

	   public void setActive(int active) {
		   this.active = active;
	   } 
}
