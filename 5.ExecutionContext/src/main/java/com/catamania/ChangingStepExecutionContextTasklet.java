package com.catamania;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


public class ChangingStepExecutionContextTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // set variable in JobExecutionContext
        chunkContext.getStepContext().getStepExecution().getExecutionContext().put("cle", "valeur");

        // exit the step
        return RepeatStatus.FINISHED;
    }
}
