/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.spring.jdbc.Customer;
import com.spring.jdbc.CustomerDAO;
import java.util.List;
import javax.ejb.Stateless;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jyo
 */
@Stateless
public class UserMaintenanceController {
    
 
    public boolean save(Customer cust){
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer_jdbc.xml");
        CustomerDAO customerDAO =  (CustomerDAO) applicationContext.getBean("customerdao");
      
        customerDAO.createCustomer(cust);
        return true;
    }
    
    @SuppressWarnings("empty-statement")
    public List<Customer> retriveAllCutomers(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer_jdbc.xml");
        CustomerDAO customerDAO =  (CustomerDAO) applicationContext.getBean("customerdao");
        return customerDAO.retrieveAllCustomers();
        
    }
}
