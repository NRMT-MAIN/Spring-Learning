package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MarriageSeeker;
import com.example.demo.respository.IMarriageSeeker;

@Service("matrimonyService")
public class MatrimonyManagementService implements IMatrimonyManagementService {
	@Autowired
	private IMarriageSeeker seekerRepo ; 
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		long idVal = seekerRepo.save(seeker).getMid() ; 
		
		return "Marriage Seeker is registered with id : " + idVal ; 
	}
	
	@Override
	public MarriageSeeker getMarriageSeekerById(Long id) {
		return seekerRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id")) ; 
	}
}
