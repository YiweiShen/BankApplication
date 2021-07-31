package com.group2.project.bankApp.bean;

public class CustomterBill {
	
	private String billerName;
	private int billerAcctNo;
	private int amount;
	private int customerId;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
