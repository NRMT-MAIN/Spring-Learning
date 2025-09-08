package com.example.demo.service;

import com.example.demo.entity.MarriageSeeker;

public interface IMatrimonyManagementService {
	public String registerMarriageSeeker(MarriageSeeker seeker) ; 
	public MarriageSeeker getMarriageSeekerById(Long id) ; 
}
