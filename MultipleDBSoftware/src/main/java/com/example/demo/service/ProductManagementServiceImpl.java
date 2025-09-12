package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.offer.Offers;
import com.example.demo.entity.prod.Product;
import com.example.demo.repository.offer.IOffersRepository;
import com.example.demo.repository.prod.IProductRepoistory;

@Service("prodService")
public class ProductManagementServiceImpl implements IProductManagementService {
	
	@Autowired
	private IProductRepoistory prodRepo ; 
	
	@Autowired
	private IOffersRepository offerRepo ;
	
	@Override
	public String registerProducts(List<Product> products) {
		prodRepo.saveAll(products) ; 
		return products.size() + " products are saved !" ; 
	}
	
	@Override
	public String registersOffers(List<Offers> offers) {
		offerRepo.saveAll(offers) ; 
		return offers.size() + " offers are saved !" ; 
	}
}
