package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.entity.CovidCases;
import com.example.demo.processor.CovidCaseDataProcessor;
import com.example.demo.repository.CovidCaseRepository;

@Configuration
public class SpringBatchConfig {
	@Autowired
	private CovidCaseRepository covidCaseRepository ; 
	
	@Autowired
	private JobRepository jobRepository ; 
	
	@Autowired
	private PlatformTransactionManager transactionManager ; 
	
	public FlatFileItemReader<CovidCases> itemReader() {
		FlatFileItemReader<CovidCases> reader = new FlatFileItemReader<>() ; 
		reader.setResource(new FileSystemResource("D:/Study_Material/JAVA/NB/covid_cases.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper()) ; 
		
		return reader ; 
	}
	
	 private LineMapper<CovidCases> lineMapper() { 
	     DefaultLineMapper<CovidCases> lineMapper = new DefaultLineMapper<>(); 
	     DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(); 
	     tokenizer.setDelimiter(","); 
	     tokenizer.setStrict(false); 
	     tokenizer.setNames("Countries", "Confirmed", "Deaths", "Recovered","Active"); 
	     BeanWrapperFieldSetMapper<CovidCases> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>(); 
	     beanWrapperFieldSetMapper.setTargetType(CovidCases.class); 
	     lineMapper.setLineTokenizer(tokenizer); 
	     lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper); 
	     return lineMapper; 
	 } 
	 
	 @Bean
	 public CovidCaseDataProcessor itemProcessor() {
		 CovidCaseDataProcessor processor = new CovidCaseDataProcessor() ; 
		 return processor ; 
	 }
	 
	 @Bean
	 public RepositoryItemWriter<CovidCases> itemWriter() {
		 RepositoryItemWriter<CovidCases> writer = new RepositoryItemWriter<>() ; 
		 writer.setRepository(covidCaseRepository);
		 writer.setMethodName("save");
		 
		 return writer ; 
	 }
	 
	 @Bean
	 public Step CovidCaseStep(JobRepository jobRepository , PlatformTransactionManager transactionManager) { 
		 return new StepBuilder("covidCaseStep", jobRepository)
				 .<CovidCases , CovidCases>chunk(10 , transactionManager)
				 .reader(itemReader())
				 .processor(itemProcessor())
				 .writer(itemWriter())
				 .build() ; 
	 }
	 
	 @Bean
	 public Job runJob(JobRepository jobRepository) {
		 return new JobBuilder("covicCasesJob" , jobRepository)
				 .flow(CovidCaseStep(jobRepository, transactionManager))
				 .end()
				 .build() ; 
	 }
}