package com.example.demo.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	@JmsListener(destination = "targetQ")
    public void readMessage(String text) {
        // Log the message content
        System.out.println("------------------------------------");
        System.out.println("RECEIVED MESSAGE:: " + text);
        System.out.println("------------------------------------");
    }
}
