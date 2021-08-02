package com.group2.project.bankApp.bean;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a bean class for Customer Account, with acctNo as int,
 *              acctType as String, acctBalance as double, customerId as int
 * 
 *              For the checking account: no interest rate, can pay bills
 * 
 *              For the saving account: has a interest rate, cannot pay bills
 **/

public class CustomerAcct {

	private int acctNo; // account number as pk
	private String acctType; // account type: checking or saving
	private double acctBalance; // account balance
	private double interestRate; // checking account's interest rate is 0, for saving account, set as 0.01
	private int customerId; // customer ID for this account

	public int getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
