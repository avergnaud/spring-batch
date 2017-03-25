package com.catamania.listeners;

import org.springframework.batch.core.ItemReadListener;

import com.catamania.Person;

public class ReadListener implements ItemReadListener<Person> {

	public void beforeRead() {
//		System.out.println("Before reading an item");		
	}

	public void onReadError(Exception ex) {
		System.out.println("Error occurred while reading an item!");		
	}

	@Override
	public void afterRead(Person item) {
		System.out.println("After reading an item: " + item.toString());	
		
	}
	
}
