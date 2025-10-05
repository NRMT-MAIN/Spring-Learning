package com.example.demo.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GenerateReport {
	
	//@Scheduled(initialDelay = 2000 , fixedDelay = 3000)
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedDelayString = "3000")
	//@Scheduled(fixedDelay = 3000)
//	@Scheduled(fixedRate = 3000)
//	public void showReport() {
//		System.out.println("report on :: " + new Date());
//		try {
//			Thread.sleep(15000) ;
//		} catch (Exception e) {
//			e.printStackTrace() ;
//		}
//	}
	
//	@Scheduled(fixedDelay = 3000)
//	public void showReport1() {
//		System.out.println("GenerateReport.showReport1() :: " + new Date() + " ---- " + Thread.currentThread());
//	}
//	
//	@Scheduled(fixedDelay = 4000)
//	public void showReport2() {
//		System.out.println("GenerateReport.showReport2() :: " + new Date() + " ---- " + Thread.currentThread());
//	}
	
	//@Scheduled(cron = "20 * * * * *")
	@Scheduled(cron = "0 20/10 * * * *")
	public void generateReport1() {
		System.out.println("GenerateReport.generateReport1() :: " + new Date());
	}
}
