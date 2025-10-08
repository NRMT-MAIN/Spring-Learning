package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.listeners.JobMonitoringListener;
import com.example.demo.processor.BookInfoItemProcessor;
import com.example.demo.reader.BookInfoItemReader;
import com.example.demo.writer.BookInfoItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobRepository jobRepository ; 
	
	@Autowired
	private PlatformTransactionManager transactionManager ; 
	
	@Autowired
	private BookInfoItemReader reader ;
	
	@Autowired
	private BookInfoItemWriter writer ; 
	
	@Autowired
	private BookInfoItemProcessor processor ; 
	
	@Autowired
	private JobMonitoringListener listener ; 
	
	@Bean(name="step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		
		return new StepBuilder("step1", jobRepository) 
                .<String, String>chunk(2, transactionManager) 
                .reader(reader)
                .writer(writer)
                .processor(processor)
                .build();
	}
	
	@Bean(name="job1")
	public Job createJob1() { 
		System.out.println("BatchConfig.createJob() - Using JobBuilder");
		
        return new JobBuilder("book-processing-job", jobRepository) 
                .incrementer(new RunIdIncrementer()) 
                .listener(listener) 
                .start(createStep1())
                .build();
	}
}
