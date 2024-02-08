package com.java.udemy.primeirospringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BatchConfig {
		
	@Bean
	public Job imprimeOlaJob(){
		return new JobBuilder("imprimeOlaJob").
				start(imprimeOlaStep()).
				build();
    	
    }
	
	public Step imprimeOlaStep() {
		return new StepBuilder("imprimeOlaStep").
				tasklet(new Tasklet() {
					
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("Ola,mundo");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
}