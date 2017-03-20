package com.catamania;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class SimpleWriter implements ItemWriter<String> {

	public void write(List<? extends String> arg0) throws Exception {
		System.out.println("[SimpleWriter.write       ] " + arg0);
	}
}
