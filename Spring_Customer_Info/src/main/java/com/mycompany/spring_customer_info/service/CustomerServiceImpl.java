package com.mycompany.spring_customer_info.service;

import com.mycompany.spring_customer_info.dao.ICustomerDao;
import com.mycompany.spring_customer_info.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nirmi
 */
@Service("CustService")
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao custDao ; 

    @Override
    public String registerCustomer(Customer cust) throws Exception {
        double discountAmount = cust.getBillAmount() * (cust.getDiscount() / 100.0) ; 
        double finalAmount = cust.getBillAmount() - discountAmount ; 
        
        cust.setTotalAmount(finalAmount);
        
        int count = custDao.insert(cust) ; 
        
        return count == 0? "Customer Registeration Failed" : "Customer Registeration Successfull!"; 
        
    }
    
}
