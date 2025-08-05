package com.mycompany.spring_customer_info.controller;

import com.mycompany.spring_customer_info.model.Customer;
import com.mycompany.spring_customer_info.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author nirmi
 */
@Controller("CustController")
public class CustomerController {
    @Autowired
    private ICustomerService custService ; 
    
    public String processCustomer(Customer cust) throws Exception{
        String result = custService.registerCustomer(cust) ; 
        
        return result ; 
    }
}
