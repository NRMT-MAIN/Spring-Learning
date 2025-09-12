package com.example.demo.runners;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.offer.Offers;
import com.example.demo.entity.prod.Product;
import com.example.demo.service.IProductManagementService;

@Component
public class MultiDBRunners implements CommandLineRunner {
	
	@Autowired
	private IProductManagementService prodService ; 
	

	@Override
	public void run(String... args) throws Exception {
		List<Product> prodList = List.of(
			new Product("Table" , 45000.00 , 5.0) , 
			new Product("Chair" , 6700.00 , 3.0) ,
			new Product("Atta" , 89000.00 , 5.5) 
		) ; 
		
		prodService.registerProducts(prodList) ; 
		
		System.out.println("----------------------------------------") ;
		
		List<Offers> offerList = List.of(
			new Offers("Diwali_Offer" , "DW06" , 10.05 , LocalDateTime.of(2023, 05, 4, 12, 58)) , 
			new Offers("Holi_Offer" , "HL8" , 10.00 , LocalDateTime.of(2023, 05, 10, 10, 38))  , 
			new Offers("Great_Sale" , "GS15" , 90.05 , LocalDateTime.of(2023, 12, 6, 12, 58)) 
		) ; 
		
		prodService.registersOffers(offerList) ; 
	}

}
