package com.example.demo.pms;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing-api")
@Slf4j
public class BillingOperationServiceController {
	
	@Value("${server.port}")
	private Integer port ; 
	
	@Value("${eureka.instance.instance-id}")
    private String instanceid;
	
	@GetMapping("/info")
	public ResponseEntity<String> showBillingInfo() {
		log.info("showBillingInfo::Method") ; 
		String msg = "Final BillAmt=BillAmt - discount (Rs.5000) :: using instance::-->" + instanceid + " @port::" + port;
        return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
