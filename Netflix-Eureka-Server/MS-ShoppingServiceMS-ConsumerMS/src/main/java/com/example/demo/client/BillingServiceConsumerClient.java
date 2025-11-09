package com.example.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class BillingServiceConsumerClient {
	
//	@Autowired
//	private DiscoveryClient client  ;
	
	@Autowired
	private LoadBalancerClient client ; 
	
	public String getBillingInfo() {
		ServiceInstance si = client.choose("BillServiceMS") ; 
		

	     if (si == null) {
	         return "Error: Billing Service not available.";
	     }
		
		
		String url = si.getUri() + "/billing-api/info" ; 
		
		RestTemplate template = new RestTemplate() ; 
		String resp = template.getForObject(url, String.class) ; 
		return resp ; 
	}
}
