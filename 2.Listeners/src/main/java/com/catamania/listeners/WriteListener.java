package com.catamania.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.catamania.Person;

public class WriteListener implements ItemWriteListener<Person> {

	@Override
	public void beforeWrite(List<? extends Person> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWrite(List<? extends Person> items) {
		System.out.println("After writing a chunk: " + items.toString());
		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Person> items) {
		// TODO Auto-generated method stub
		
	}

}
