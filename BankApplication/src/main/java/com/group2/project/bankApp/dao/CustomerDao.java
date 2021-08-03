package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.Login;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a dao class for crud operations of Customer Table
 **/

public class CustomerDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int register(Customer c) {
	    String sql = "insert into customerTbl values(?,?,?,?,?,?,?,?)";

	    return template.update(sql, new Object[] { c.getCustomerId(), c.getUserId(), c.getFirstName(), c.getLastName(),
	    		 c.getAddress(), c.getState(), c.getCountry(), c.getPostalCode() });
	}
	
	public List<Customer> getCustomer(Login l) {
		return template.query("select * from customerTbl where userId = " + l.getUserId(), new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int row) throws SQLException {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setUserId(rs.getString(2));
				c.setFirstName(rs.getString(3));
				c.setLastName(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setState(rs.getString(6));
				c.setCountry(rs.getString(7));
				c.setPostalCode(rs.getString(8));			
				return c;
			}
		});
	}
	
	public Customer getCustomerById(int id){  
	    String sql="select * from customerTbl where customerId=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));  
	}
	
	public int updateCustomer(Customer c, int id) {
		String sql = "update customerTbl set firstName= '" + c.getFirstName() + ", lastName='" + c.getLastName() + "', address='" + c.getAddress() + "', state= '"
				+ c.getState() + "', country= '" + c.getCountry() + "', postalCode= '" + c.getPostalCode() + "' where customerId=" + id + "";
		return template.update(sql);
	}

}
