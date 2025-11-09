package com.example.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {
	
	@Autowired
	private DiscoveryClient client  ;
	
	public String getBillingInfo() {
		List<ServiceInstance> lsi = client.getInstances("BillServiceMS") ;
		
		if(lsi == null || lsi.isEmpty()) {
			return "Error: Billing Service not available in Eureka Registry.";
		}
		
		ServiceInstance si = lsi.get(0) ; 
		
		String url = si.getUri() + "/billing-api/info" ; 
		
		RestTemplate template = new RestTemplate() ; 
		String resp = template.getForObject(url, String.class) ; 
		return resp ; 
	}
}
