package com.mycompany.spring_customer_info.app;



import com.mycompany.spring_customer_info.controller.CustomerController;
import com.mycompany.spring_customer_info.model.Customer;
import java.util.Scanner;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter Customer name : ");
        String name = sc.next() ; 
        System.out.print("Enter Customer address : ");
        String addr = sc.next() ;
        System.out.print("Enter Customer bill amount : ");
        double billAmt = sc.nextDouble();
        System.out.print("Enter Customer discount percentage : ");
        double discount = sc.nextDouble();
        
        Customer cust = new Customer() ; 
        cust.setCname(name);
        cust.setCadd(addr);
        cust.setBillAmount(billAmt);
        cust.setDiscount(discount);
           
        //Create IOC Container
        
        FileSystemXmlApplicationContext ctx = 
                new FileSystemXmlApplicationContext("D:/Spring Learning/Spring_Customer_Info/src/main/java/com/mycompany/spring_customer_info/config/applicationContext.xml");

        
        //get controller class object from the IOC container(dependency lookup)
        CustomerController cc = ctx.getBean("CustController" , CustomerController.class) ; 
        
        try {
            String resultMsg = cc.processCustomer(cust) ; 
            System.out.println(resultMsg);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        ctx.close();
    }
}
