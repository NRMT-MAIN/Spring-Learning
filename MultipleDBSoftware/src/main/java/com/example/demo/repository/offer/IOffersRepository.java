package com.example.demo.repository.offer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.offer.Offers;

public interface IOffersRepository extends JpaRepository<Offers, Integer> {

}
