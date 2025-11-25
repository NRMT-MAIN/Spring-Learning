package com.example.demo.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.BillingServiceConsumerClient;
import com.example.demo.client.IBillingServiceConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceOperationController {
	
//	@Autowired
//	private BillingServiceConsumerClient client ; 
	
	@Autowired
	private IBillingServiceConsumer consumer ; 
	
	@GetMapping("/details")
    public String displayShoppingDetails() {
        ResponseEntity<String> billInfo = consumer.fetchBillDetails();
        
        System.out.println("Client Comp Class Name (Proxy): " + consumer.getClass());
        
        return "Pongal Shopping for Family .... Result from Billing: " + billInfo;
    }
}
