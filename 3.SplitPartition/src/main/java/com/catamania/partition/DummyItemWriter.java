package com.catamania.partition;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.catamania.Person;


public class DummyItemWriter implements ItemWriter<Person> {
	public void write(List<? extends Person> arg0) throws Exception {

		System.out.println(Thread.currentThread().getName() + " writes " + arg0);
	}
}
