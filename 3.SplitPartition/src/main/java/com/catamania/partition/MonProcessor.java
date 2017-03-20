package com.catamania.partition;

import org.springframework.batch.item.ItemProcessor;

import com.catamania.Person;

public class MonProcessor implements ItemProcessor<Person, Person> {

	public Person process(Person arg0) throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " processes " + arg0.getFirstName());
		return arg0;
	}

}
