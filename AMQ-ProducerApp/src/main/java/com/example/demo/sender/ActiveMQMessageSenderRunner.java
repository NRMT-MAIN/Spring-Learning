package com.example.demo.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner {
	
	String queue = "targetQ" ; 
	
	@Autowired
	private JmsTemplate template ; 

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		template.send(queue , ses -> {
			return ses.createTextMessage("From sender at : " + new Date()) ; 
		});
		
	}

}
