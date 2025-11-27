package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.UserDetails;

public interface IUserRepository extends CrudRepository<UserDetails, Integer> {
	Optional<UserDetails> findByUname(String uname); 
}
