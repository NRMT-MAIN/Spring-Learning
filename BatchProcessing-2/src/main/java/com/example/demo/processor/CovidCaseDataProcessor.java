package com.example.demo.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.entity.CovidCases;

public class CovidCaseDataProcessor implements ItemProcessor<CovidCases, CovidCases> {
	
	@Override
	public CovidCases process(CovidCases item) throws Exception {
		item.setCountry(item.getCountry().toUpperCase());
		return item ;
	}

}
