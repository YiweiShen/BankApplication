package com.group2.project.bankApp.bean;

import javax.validation.constraints.NotNull;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description login class for Login, with columns as userId as String,
 *              password as String user ID is chosen by the customer self, but
 *              we need to double check during customer registration if the user
 *              ID already exists in the database to avoid duplicates
 **/

public class Login {
	@NotNull(message = "required")
	private String userId;
	@NotNull(message = "required")
	private String password;

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
