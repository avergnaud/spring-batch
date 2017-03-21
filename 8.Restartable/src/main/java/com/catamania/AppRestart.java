package com.catamania;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.JobParametersNotFoundException;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRestart {
	
	public static void main(String[] args) {

		String[] springConfig = { "SimpleJob.xml" };
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);) {
			
//			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			
			JobOperator jobOperator = (JobOperator) context.getBean("jobOperator");
			
//			Job job = (Job) context.getBean("restartableJobTest");

//			JobExecution execution = jobLauncher.run(job, new JobParameters());
			
			Long l = null;
				
			l = jobOperator.restart(44);
			
			
		}  catch (NoSuchJobException | JobRestartException
				 | JobInstanceAlreadyCompleteException
				| UnexpectedJobExecutionException | JobParametersInvalidException | NoSuchJobExecutionException e) {
			/* Spring-Batch exceptions */
			e.printStackTrace();
		} 
	}
}
