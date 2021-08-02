package com.group2.project.bankApp.bean;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description this is a bean class for Customer, with customerId as int,
 *              userId as String, firstName as String, lastName as String,
 *              address as String, state as String, state as String, country as
 *              String, postalCode as String
 **/

public class Customer {

	private int customerId; // system generated integer as pk
	private String userId; // user-created string for identity
	private String firstName; // user's first name
	private String lastName; // user's last name
	private String address; // we don't allow multiple address for one customer
	private String state; // state for the customer address
	private String country; // country for the customer address
	private String postalCode; // postal code for the customer address

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
