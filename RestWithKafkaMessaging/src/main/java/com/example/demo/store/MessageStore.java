package com.example.demo.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("msgStore")
public class MessageStore {
	private List<String> listMessages = Collections.synchronizedList(new ArrayList<>()) ; 
	
	public void addMessage(String message) {
        listMessages.add(message);
    }

    public String getAllMessages() {
        return listMessages.toString();
    }
}
