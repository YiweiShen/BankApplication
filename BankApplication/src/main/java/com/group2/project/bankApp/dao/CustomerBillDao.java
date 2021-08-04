package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerBill;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a dao class for crud operations of CustomerBill Table
 **/

public class CustomerBillDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(CustomerBill b) {
		String sql = "insert into customerBillTbl (billerName, billerAcctNo, amount, customerId) values (?,?,?,?)";
		return template.update(sql,
				new Object[] { b.getBillerName(), b.getBillerAcctNo(), b.getAmount(), b.getCustomerId() });
	}

	public List<CustomerBill> getBill(Customer c) {
		return template.query("select * from customerBillTbl where customerId= " + c.getCustomerId(),
				new RowMapper<CustomerBill>() {
					public CustomerBill mapRow(ResultSet rs, int row) throws SQLException {
						CustomerBill b = new CustomerBill();
						b.setBillNo(rs.getInt(1));
						b.setBillerName(rs.getString(2));
						b.setBillerAcctNo(rs.getInt(3));
						b.setAmount(rs.getDouble(4));
						b.setCustomerId(rs.getInt(5));
						return b;
					}
				});
	}

}
