package com.example.demo.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.IMToMManagementService;

@Component
public class MtoMTestRunner implements CommandLineRunner {

	@Autowired
	private IMToMManagementService service ; 
	
	@Override
	public void run(String... args) throws Exception {
		service.saveDataUsingDoctor();
	}

}
