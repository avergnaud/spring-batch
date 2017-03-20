package com.catamania;

import java.util.List;

import org.springframework.batch.item.support.ListItemReader;

/*
https://github.com/spring-projects/spring-batch/blob/master/spring-batch-infrastructure/src/main/java/org/springframework/batch/item/support/ListItemReader.java
*/

public class SimpleReader extends ListItemReader<String> {

    public SimpleReader(List<String> list) {
        super(list);
        System.out.println("[SimpleReader constructor ] Reading data list " + list);
    }

    @Override
    public String read() {
        String out = (String) super.read();
        
        if("d".equals(out)) {        	
        	throw new MyRuntimeException();
//        	throw new MyCheckedException(); illegal
        	// http://docs.spring.io/spring-batch/reference/html/configureStep.html#configuringSkip
        }
        
        System.out.println("[SimpleReader.read        ] Reading data " + out);
        return out;
    }

}