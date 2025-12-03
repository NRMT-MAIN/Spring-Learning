package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producers.MessageProducer;
import com.example.demo.store.MessageStore;

@RestController
public class KafkaMessagingHandlingController {
	@Autowired
    private MessageProducer producer; 

    @Autowired
    private MessageStore store; 

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        String status = producer.sendMessage(message);
        System.out.println(status) ; 
        return new ResponseEntity<String>(status , HttpStatus.OK);
    }

    @GetMapping("/readAll")
    public ResponseEntity<String> fetchAllMessage() {
    	String msg = store.getAllMessages() ; 
    	return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
}
