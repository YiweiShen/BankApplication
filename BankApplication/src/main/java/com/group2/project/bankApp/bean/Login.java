package com.group2.project.bankApp.bean;

import javax.validation.constraints.NotNull;
/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description login class for loginTbl, with columns as
 * userId as int, password as string
 * **/

public class Login {
	@NotNull(message="required")
	private int userId;
	@NotNull(message="required")
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
