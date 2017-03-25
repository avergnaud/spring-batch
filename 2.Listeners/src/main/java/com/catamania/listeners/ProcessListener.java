package com.catamania.listeners;

import org.springframework.batch.core.ItemProcessListener;

import com.catamania.Person;

public class ProcessListener implements ItemProcessListener<Person,Person> {

	@Override
	public void beforeProcess(Person item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterProcess(Person item, Person result) {
		System.out.println("After processing an item: " + item.toString());
		
	}

	@Override
	public void onProcessError(Person item, Exception e) {
		// TODO Auto-generated method stub
		
	}


}
