package com.beans;


import com.ejb.UserMaintenanceController;
import com.spring.jdbc.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jyo
 */
@Model
public class Index {
    
    private String name;
    private Integer age;
    
    
    @EJB
    UserMaintenanceController umc;
 
    
    public String save(){
        
        Customer customer = new Customer();
        customer.setAge(getAge());
        customer.setName(getName());
        
        umc.save(customer);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Customer[] getAllCustomers(){
        List<Customer> custList = umc.retriveAllCutomers();
        Customer[] custArray = custList.toArray(new Customer[custList.size()]);
        return custArray;
    }
}
