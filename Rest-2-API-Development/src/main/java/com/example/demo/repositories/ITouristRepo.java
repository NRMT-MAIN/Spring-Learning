package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
	@Query("delete from Tourist where packageType=:type")
	public int deleteTouristByPackageType(String type) ; 
}
