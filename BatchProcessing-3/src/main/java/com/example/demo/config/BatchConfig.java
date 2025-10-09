package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.listeners.JobMonitoringListener;
import com.example.demo.model.Employee;
import com.example.demo.processor.EmployeeItemProcessor;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing 
public class BatchConfig {
    
    @Autowired private JobRepository jobRepository;
    @Autowired private PlatformTransactionManager transactionManager; 
    @Autowired private DataSource ds; 
    
    @Autowired private JobMonitoringListener listener;
    @Autowired private EmployeeItemProcessor processor;

    @Bean(name="ffiReader")
    public FlatFileItemReader<Employee> createFFIReader() {
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("EMP_CSV.csv")); 
        
        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
        
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setNames("empno", "ename", "eadd", "salary"); 
        
        BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Employee.class);
        
        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.setLineTokenizer(tokenizer);
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean(name="jbiw")
    public JdbcBatchItemWriter<Employee> createJBIWriter() {
        JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(ds);
        
        writer.setSql("INSERT INTO EMP_CSV(EMPNO, ENAME, EADD, SALARY, GROSSSALARY, NETSALARY) VALUES (:empno, :ename, :eadd, :salary, :grossSalary, :netSalary)");
        

        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }


    @Bean(name="step1")
    public Step createStep1() {
        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee>chunk(5, transactionManager) 
                .reader(createFFIReader())
                .processor(processor)
                .writer(createJBIWriter())
                .build();
    }


    @Bean(name="job1")
    public Job createJob1() {
        return new JobBuilder("job1", jobRepository)
                .listener(listener)
                .incrementer(new RunIdIncrementer())
                .start(createStep1())
                .build();
    }
}
