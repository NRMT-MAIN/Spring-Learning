package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.store.MessageStore;

@Component("msgConsumer")
public class MessageConsumer {
	@Autowired
	private MessageStore store ; 
	
	@KafkaListener(topics = "${app.topic.name}", groupId = "grp1")
    public void readMessage(String message) {
        System.out.println("RECEIVED ASYNC MESSAGE: " + message);
        store.addMessage(message);
    }
}
