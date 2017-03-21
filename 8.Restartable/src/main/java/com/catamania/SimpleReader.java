package com.catamania;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;

/*
http://docs.spring.io/spring-batch/reference/htmlsingle/#restartableReader
https://github.com/spring-projects/spring-batch/blob/master/spring-batch-infrastructure/src/main/java/org/springframework/batch/item/support/ListItemReader.java
Le reader devient stateful !
*/

public class SimpleReader implements ItemReader<String>, ItemStream {

	private List<String> list;
	
	/* for restart */
    int currentIndex = 0;
    private static final String CURRENT_INDEX = "current.index";
	
    public SimpleReader(List<String> list) {
    	this.list = new ArrayList<String>(list);
    }

    public String read() {
    	
    	

    	if (currentIndex < list.size()) {
    		String item = list.get(currentIndex++);
    		
    		/* mock pour simuler une exception */
    		if("c".equals(item) && Math.random() >0.5) {
    			throw new MyRuntimeException();/* non skippée */
    		}
    		
            return item;
        }

        return null;
    }

    /* FROM ItemStream : */
    
	@Override
	public void close() throws ItemStreamException {}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
        if(executionContext.containsKey(CURRENT_INDEX)){
            currentIndex = new Long(executionContext.getLong(CURRENT_INDEX)).intValue();
        }
        else{
            currentIndex = 0;
        }
		
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.putLong(CURRENT_INDEX, new Long(currentIndex).longValue());
	}

}