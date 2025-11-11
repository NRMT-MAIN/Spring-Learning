package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BillServiceMS")
public interface IBillingServiceConsumer {
	@GetMapping("/billing-api/info") 
    public ResponseEntity<String> fetchBillDetails();
}
