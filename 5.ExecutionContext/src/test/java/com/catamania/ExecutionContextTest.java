package com.catamania;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath*:setup/*.xml", "classpath*:executionContextJob.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExecutionContextTest {

	/** JobLauncherTestUtils Bean. */
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	/** Launch Test. */
	@Test
	public void launchJob() throws Exception {
		// launch the job
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		// assert job run status
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}

}
