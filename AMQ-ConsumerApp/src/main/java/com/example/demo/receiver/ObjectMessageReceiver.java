package com.example.demo.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.models.ActorInfo;

@Component
public class ObjectMessageReceiver {
	@JmsListener(destination = "obj_mq1")
    public void consumeObjectDataAsMessage(ActorInfo actor) {
        // The Java object is fully reconstructed and available
        System.out.println("------------------------------------");
        System.out.println("Received Object Data :: " + actor);
        System.out.println("------------------------------------");
    }
}
