package com.group2.project.bankApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group2.project.bankApp.bean.Login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public int register(Login l) {
		String sql = "insert into loginTbl values(?,?)";

		return template.update(sql, new Object[] { l.getUserId(), hashPassword(l.getPassword()) });
	}

	// validate if login/hashedPassword entered are the same in the loginTbl
	public Login validateUser(Login l) {
		String sql = "select * from loginTbl where userId='" + l.getUserId() + "' and password='"
				+ hashPassword(l.getPassword()) + "'";
		List<Login> login = template.query(sql, new UserMapper());

		return login.size() > 0 ? login.get(0) : null;
	}

	public Login checkUserExist(Login l) {
		String sql = "select * from loginTbl where userId='" + l.getUserId() + "'";
		List<Login> login = template.query(sql, new UserMapper());
		return login.size() > 0 ? login.get(0) : null;
	}

	// store password as SHA-512 hash
	// Ref: SHA-512 Hash In Java
	// https://www.geeksforgeeks.org/sha-512-hash-in-java/

	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashedPassword = no.toString(16);
			while (hashedPassword.length() < 32) {
				hashedPassword = "0" + hashedPassword;
			}
			return hashedPassword;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}

class UserMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int arg) throws SQLException {
		Login login = new Login();

		login.setUserId(rs.getString(1));
		login.setPassword(rs.getString(2));

		return login;
	}
}