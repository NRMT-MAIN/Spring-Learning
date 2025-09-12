package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.offer.Offers;
import com.example.demo.entity.prod.Product;

public interface IProductManagementService {
	public String registerProducts(List<Product> products) ; 
	public String registersOffers(List<Offers> offers) ; 
}
