package com.group2.project.bankApp.bean;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a bean class for Customer bills, with billerName as
 *              String, billerAcctNo as int, amount as double, customerId as int
 **/

public class CustomerBill {

	private String billerName; // biller's name
	private int billerAcctNo; // biller's account number
	private double amount; // the bill amount
	private int customerId; // customer related to this bill

	public String getBillerName() {
		return billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public int getBillerAcctNo() {
		return billerAcctNo;
	}

	public void setBillerAcctNo(int billerAcctNo) {
		this.billerAcctNo = billerAcctNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
