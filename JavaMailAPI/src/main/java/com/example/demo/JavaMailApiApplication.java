package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.service.IPurchaseOrder;

@SpringBootApplication
public class JavaMailApiApplication {

	public static void main(String[] args) {
		//Get Application Context Container
		ApplicationContext ctx =  SpringApplication.run(JavaMailApiApplication.class, args);
		
		IPurchaseOrder service = ctx.getBean("purchaseOrderService" , IPurchaseOrder.class) ; 
		
		//Invoke the business Method
		try {
			String msg = service.purchase(new String[] {"shirt" , "t-shirts" }, new double[] {1200.00 , 4152.34}, 
					new String[] {"nirmitsahu.aitp@gmailcom" , "nirmitsahu.main@gmail.com"}) ; 
			System.out.println(msg) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext)ctx).close();
	}

}
