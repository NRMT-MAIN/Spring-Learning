package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Tourist;
import com.example.demo.error.TouristNotFoundException;

public interface ITouristMgmtService {
	String registerTourist(Tourist tourist) ; 
	List<Tourist> fetchAllTourist() ; 
	Tourist fetchTouristById(Integer tid) throws TouristNotFoundException ; 
	String modifyTourist(Tourist tourist) ; 
	String updateTouristBudgetById(int tid, double hikePercentage) throws TouristNotFoundException; 
	String removeTouristById(int id) throws TouristNotFoundException ; 
	String removeTouristByPackageType(String type) ; 
}
