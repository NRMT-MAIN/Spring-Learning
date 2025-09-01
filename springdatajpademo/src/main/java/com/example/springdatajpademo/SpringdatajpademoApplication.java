package com.example.springdatajpademo;

import com.example.springdatajpademo.entitty.Customer;
import com.example.springdatajpademo.service.ICustomerManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdatajpademoApplication {

    public static void main(String[] args) {
        //Get the IOC Container
	ApplicationContext ctx = SpringApplication.run(SpringdatajpademoApplication.class, args);
        
        //Get service class object
        ICustomerManagementService service = ctx.getBean("custService" , ICustomerManagementService.class) ;
        
//        try {
//            Customer cust = new Customer() ; 
//            cust.setCname("Nirmit Sahu");
//            cust.setCaddrs("Pune") ; 
//            cust.setBillAmt(4545.4f) ; 
//            String resultMsg = service.registerCustomer(cust) ; 
//            System.out.println(resultMsg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
    }
}
