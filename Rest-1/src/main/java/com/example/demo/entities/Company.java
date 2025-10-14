package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Company {
	private String name;
    private String addrs;
    private String type;
    private Integer size;
}
