package com.example.demo.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jobListener")
public class JobMonitoringListener implements JobExecutionListener {
	private long start , end ; 
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		start = System.currentTimeMillis() ; 
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		end = System.currentTimeMillis() ; 
		System.out.println("Final Job Status: " + jobExecution.getStatus());
        System.out.println("Job Execution time: " + (end - start) + " ms");
        System.out.println("Job Exit Status: " + jobExecution.getExitStatus());
	}
}
