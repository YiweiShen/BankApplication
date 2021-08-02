package com.group2.project.bankApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.Login;
import com.group2.project.bankApp.dao.CustomerDao;

public class CustomerController {
	CustomerDao dao;
	
	@RequestMapping("/info")
	public String viewInfo(Model m, Login l) {
		List<Customer> list = dao.getCustomer(l);
		System.out.print(list);
		m.addAttribute("list", list);
		return "info";
	}
	
	@RequestMapping(value = "/editcustomer/{id}")
	public String edit(@PathVariable int id, Model m) {
		Customer customer = dao.getCustomerById(id);
		m.addAttribute("command", customer);
		return "redirect:/info";
	}

}
