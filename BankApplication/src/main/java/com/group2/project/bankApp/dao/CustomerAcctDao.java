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
 * @description this is a dao class for crud operations of CustomerAccount Table
 **/

public class CustomerAcctDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int deposit(CustomerAcct c, int i) {
		String sql = "update customerAccttbl set acctBalance= acctBalance + " + c.getAcctBalance() + " where id=" + i + "";
		return template.update(sql);
	}
	
	public int draw(CustomerAcct c, int i) {
		String sql = "update customerAccttbl set acctBalance= acctBalance - " + c.getAcctBalance() + " where id=" + i + "";
		return template.update(sql);
	}
	
	public int transfer(CustomerAcct c, int i) {
		String sql1 = "update customerAccttbl set acctBalance= acctBalance - " + c.getAcctBalance() + " where id=" + i + "";
		String sql2 = "update customerAccttbl set acctBalance= acctBalance + " + c.getAcctBalance() + " where id=" + c.getAcctNo() + "";
		int a = template.update(sql1);
		int b = template.update(sql2);
		return a + b;
	}
	
	public List<CustomerAcct> getAccounts(Customer c) {
		return template.query("select * from customerAccttbl where customerId = " + c.getCustomerId(), new RowMapper<CustomerAcct>() {
			public CustomerAcct mapRow(ResultSet rs, int row) throws SQLException {
				CustomerAcct c = new CustomerAcct();
				c.setAcctNo(rs.getInt(1));
				c.setAcctType(rs.getString(2));
				c.setAcctBalance(rs.getDouble(3));
				c.setCustomerId(rs.getInt(4));			
				return c;
			}
		});
	}

}
