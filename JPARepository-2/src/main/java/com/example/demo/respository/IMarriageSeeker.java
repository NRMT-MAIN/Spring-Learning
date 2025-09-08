package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MarriageSeeker;

public interface IMarriageSeeker extends JpaRepository<MarriageSeeker, Long> {

}
