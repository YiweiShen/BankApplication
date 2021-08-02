package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Login;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a dao class for crud operations of Login Table
 **/

public class LoginDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Login getPasswordByUserId(int userId) {
		String sql = "select * from logintbl where userId=?";
		return template.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper<Login>(Login.class));
	}

	
	// validate if login/password entered are the same in the loginTbl
	public Login validateUser(Login l) {
		String sql = "select * from logintbl where userId='" + l.getUserId() + "' and password='"
				+ l.getPassword() + "'";
		List<Login> login = template.query(sql, new UserMapper());

		return login.size() > 0 ? login.get(0) : null;
	}

}

class UserMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int arg) throws SQLException {
		Login login = new Login();

		login.setUserId(rs.getString("userid"));
		login.setPassword(rs.getString("password"));

		return login;
	}
}