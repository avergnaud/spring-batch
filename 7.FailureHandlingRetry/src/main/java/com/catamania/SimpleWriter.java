package com.catamania;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class SimpleWriter implements ItemWriter<String> {

	public void write(List<? extends String> arg0) throws Exception {
		
        if(Math.random() > 0.5) {     
        	System.out.println("[write MyRuntimeException ] writing data " + arg0);
        	throw new MyRuntimeException();/* should be retried */
        }
		
		System.out.println("[SimpleWriter.write       ] " + arg0);
	}
}
