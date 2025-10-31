package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tourist;
import com.example.demo.repositories.ITouristRepo;

@Service("touristMgmtService")
public class TouristServiceMgmtImpl implements ITouristMgmtService {
	
	@Autowired
	private ITouristRepo touristRepo ; 
	
	@Override
	public String registerTourist(Tourist tourist) {
		
		int idVal = touristRepo.save(tourist).getTid() ; 
		
		 return "Tourist is registered having the ID value :: " + idVal;
	}
}
