package com.catamania;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.JobParametersNotFoundException;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {

		String[] springConfig = { "SimpleJob.xml" };

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);) {
			
//			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			
//			Job job = (Job) context.getBean("simpleJob");
//
//			JobExecution execution = jobLauncher.run(job, new JobParameters());
//			
			JobOperator jobOperator = (JobOperator) context.getBean("jobOperator");
			
			Long l = jobOperator.startNextInstance("simpleJob");
			

		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException | NoSuchJobException | JobParametersNotFoundException | UnexpectedJobExecutionException e) {
			e.printStackTrace();
		}
	}
}
