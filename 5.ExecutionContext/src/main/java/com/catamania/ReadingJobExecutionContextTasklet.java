package com.catamania;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ReadingJobExecutionContextTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // pull variable from JobExecutionContext, accesses a unmodifiable map
        String value = (String) chunkContext.getStepContext().getJobExecutionContext().get("cle");

        // check for the value
        if (value != null) {
            System.out.println("Found : " + value);
        } else {
            throw new Exception("Did not found value in JobExecutionContext");
        }

        // exit the step
        return RepeatStatus.FINISHED;
    }
}
