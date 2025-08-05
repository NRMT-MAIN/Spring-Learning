package com.mycompany.spring_customer_info.dao;

import com.mycompany.spring_customer_info.model.Customer;

/**
 *
 * @author nirmi
 */
public interface ICustomerDao {
    public int insert(Customer cust) throws Exception ; 
}
