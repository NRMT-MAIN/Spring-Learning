package com.mycompany.spring_customer_info.dao;

import com.mycompany.spring_customer_info.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nirmi
 */
@Repository("CustDao")
public class CustomerDao implements ICustomerDao {
    private static final String QUERY = 
           "INSERT INTO SPRING_CUSTOMER_INFO VALUES(CNO_SEQ1.NEXTVAL, ? , ? , ? , ? , ?)" ; 
    
    @Autowired
    private DataSource ds;
    
    @Override
    public int insert(Customer cust) throws Exception {
        int count = 0 ; 
        try(
            Connection con = ds.getConnection() ; 
            PreparedStatement ps = con.prepareStatement(QUERY) ; 
        ){
            ps.setString(1, cust.getCname());
            ps.setString(2, cust.getCadd());
            ps.setDouble(3, cust.getBillAmount());
            ps.setDouble(4, cust.getDiscount());
            ps.setDouble(5, cust.getTotalAmount());
            
            count = ps.executeUpdate() ; 
        } catch(SQLException se) {
            se.printStackTrace();
            throw se ; 
        }
       
        return count ; 
    }
    
}
