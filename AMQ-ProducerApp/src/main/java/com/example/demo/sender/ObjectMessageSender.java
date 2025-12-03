package com.example.demo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.models.ActorInfo;

@Component
public class ObjectMessageSender {

	@Autowired
    private JmsTemplate template;


    @Scheduled(cron = "0/20 * * * * * ")
    public void sendObjectDataAsMessage() {
    	ActorInfo actor = new ActorInfo(1001, "ranveer", "mumbai"); 
        
        // Use convertAndSend: Spring handles the serialization (Object -> JMS Message)
        template.convertAndSend("obj_mq1", actor); 
        
        System.out.println("Message sent: " + actor);
    }
}
