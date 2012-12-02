/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jyo
 */
public class CustomerDAOImpl implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;
    
    private final String select = "SELECT * FROM CUSTOMER WHERE ID= ?";
    private final String insert = "INSERT INTO CUSTOMER( NAME, AGE) VALUES(?,?)";
    private final String retrieveall = "SELECT * FROM CUSTOMER";
    

    
    
    @Override
    public Customer getCustomer(Integer customerId) {
        
        Customer c = (Customer)getJdbcTemplate().queryForObject(select, new Object[]{customerId}, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
             
                Customer cust = new Customer();
                cust.setId(new Integer(rs.getString("ID")));
                cust.setName(rs.getString("NAME"));
                cust.setAge(new Integer(rs.getString("AGE")));
                return cust;
            }
        });
        return c;
    }

    @Override
    public int createCustomer(Customer newCustomer) {
       return getJdbcTemplate().update(insert, new Object[]{newCustomer.getName(),newCustomer.getAge()});
    }

    @Override
    public List<Customer> retrieveAllCustomers() {
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(retrieveall);
       
        
        List<Customer> custList = new ArrayList<Customer>();
        for(Iterator itr = list.iterator(); itr.hasNext();){
            Map<String, Object> map = (Map<String, Object>) itr.next();
           
            Integer id = (Integer) map.get("ID");
            String name = (String)map.get("NAME");
            Integer age = (Integer)map.get("AGE");
            
            Customer cust = new Customer(id,name,age);
            
            custList.add(cust);
            
        }
            
        return custList;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
