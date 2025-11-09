package com.example.demo.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceOperationController {
	
	@Autowired
	private BillingServiceConsumerClient client ; 
	
	@GetMapping("/details")
    public ResponseEntity<String> showBillingDetails() {
        
        String billInfo = "Bill amount::" + new Random().nextInt(100000);
        
        String providerResult = client.getBillingInfo();
        
        return new ResponseEntity<>(billInfo + "....." + providerResult, HttpStatus.OK);
    }
}
