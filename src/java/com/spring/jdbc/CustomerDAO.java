/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.jdbc;

import java.util.List;

/**
 *
 * @author codedairy
 */
public interface CustomerDAO {
    
    public Customer getCustomer(Integer customerId);
    public int createCustomer(Customer newCustomer);
    public List<Customer> retrieveAllCustomers();
            
    
}
