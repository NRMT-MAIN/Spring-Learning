package com.example.demo.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("biReader")
public class BookInfoItemReader implements ItemReader<String> {
	
	private final String[] books = new String[] {"CRJ", "TIJ", "HFJ", "EJ", "BBJ"}; 
	int count = 0 ; 

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookInfoItemReader.read()");
		
		if(count < books.length) {
			return books[count++] ; 
		}
		
		return null;
	}

}
