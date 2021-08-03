package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerAcct;

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
	
	public int register(CustomerAcct c) {
	    String sql = "insert into customerAcctTbl values(?,?,?,?,?)";

	    return template.update(sql, new Object[] { c.getAcctNo(), c.getAcctType(), c.getAcctBalance(), c.getInterestRate(),
	    		 c.getCustomerId() });
	}
	
	public int deposit(CustomerAcct c, double amount) {
		String sql = "update customerAcctTbl set acctBalance=" + String.valueOf(c.getAcctBalance()+amount) + " where acctNo=" + c.getAcctNo() + "";
		return template.update(sql);
	}
	
	// checking if the balance is sufficient for the withdraw is done in controller
	public int draw(CustomerAcct c, double amount) {
		String sql = "update customerAcctTbl set acctBalance=" + String.valueOf(c.getAcctBalance()-amount) + " where acctNo=" + c.getAcctNo() + "";
		return template.update(sql);
	}
	
	// c1 account transfer to c2 account for amount of money
	// checking if the balance of c1 is sufficient for the transfer is done in controller
	public int transfer(CustomerAcct c1, CustomerAcct c2, double amount) {
		String sql1 = "update customerAcctTbl set acctBalance=" + String.valueOf(c1.getAcctBalance()-amount) + " where acctNo=" + c1.getAcctNo() + "";
		String sql2 = "update customerAcctTbl set acctBalance=" + String.valueOf(c2.getAcctBalance()+amount) + " where acctNo=" + c2.getAcctNo() + "";
		int a = template.update(sql1);
		int b = template.update(sql2);
		return a + b;
	}
	
	public List<CustomerAcct> getAccounts(Customer c) {
		return template.query("select * from customerAcctTbl where customerId = " + c.getCustomerId(), new RowMapper<CustomerAcct>() {
			public CustomerAcct mapRow(ResultSet rs, int row) throws SQLException {
				CustomerAcct c = new CustomerAcct();
				c.setAcctNo(rs.getInt(1));
				c.setAcctType(rs.getString(2));
				c.setAcctBalance(rs.getDouble(3));
				c.setInterestRate(rs.getDouble(4));
				c.setCustomerId(rs.getInt(5));			
				return c;
			}
		});
	}

}
