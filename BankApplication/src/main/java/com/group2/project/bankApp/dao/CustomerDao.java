package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerAcct;
import com.group2.project.bankApp.bean.Login;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a dao class for crud operations of Customer Table
 **/

public class CustomerDao {
	JdbcTemplate template;
	
	public List<Customer> getCustomer(Login l) {
		return template.query("select * from customertbl where userId = " + l.getUserId(), new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int row) throws SQLException {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt(0));
				c.setUserId(rs.getString(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setAddress(rs.getString(4));
				c.setState(rs.getString(5));
				c.setCountry(rs.getString(6));
				c.setPostalCode(rs.getString(7));			
				return c;
			}
		});
	}
	
	public Customer getCustomerById(int id){  
	    String sql="select * from customertbl where customerId=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));  
	}
	
	public int update(Customer c, int id) {
		String sql = "update customertbl set firstName= '" + c.getFirstName() + ", lastName='" + c.getLastName() + "', address='" + c.getAddress() + "', state= '"
				+ c.getState() + "', country= '" + c.getCountry() + "', postalCode= '" + c.getPostalCode() + "' where customerId=" + id + "";
		return template.update(sql);
	}

}
