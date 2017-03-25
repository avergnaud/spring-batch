package com.catamania;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			/* injection : */
			HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
			System.out.println(obj.getMessage());
		}	
	}
}
