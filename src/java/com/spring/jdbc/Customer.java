/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.jdbc;

/**
 *
 * @author jyo
 */
public class Customer {
    
    private Integer id;
    private String name;
    private Integer age;

    Customer(Integer id, String name, Integer age) {
     
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer() {
       ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  " " + this.id + " " + this.name + "  " + this.age;
    }
    
    
}
