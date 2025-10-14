package com.example.demo.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	private Integer cno ; 
	private String cname ; 
	private String cadd ; 
	private float billAmt ; 
	private String[] favColors;
    private List<String> studies;
    private Set<Long> phoeNumbers;
    private Map<String, Object> idDetails; 
    private Company company; 
}
