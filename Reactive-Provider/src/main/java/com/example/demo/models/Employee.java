package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
    private String id; // Use String for MongoDB ID
    private String empName;
    private String empDept;
    private Double empSal;
}
