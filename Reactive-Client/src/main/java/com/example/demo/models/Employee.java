package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	public Employee(Object object, String string, String string2, double d) {
		// TODO Auto-generated constructor stub
	}
	private String id; 
    private String empName;
    private String empDept;
    private Double empSal;
}
