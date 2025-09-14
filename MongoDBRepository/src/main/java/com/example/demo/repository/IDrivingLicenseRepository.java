package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.DrivingLicense;


public interface IDrivingLicenseRepository extends MongoRepository<DrivingLicense, String> {

}
