package com.group2.project.bankApp.controller;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for CustomerAccount, bridging between
 * beans / CustomerAcctDao and related views
 * **/

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerAcct;
import com.group2.project.bankApp.dao.CustomerAcctDao;



public class CustomerAcctController {
	CustomerAcctDao dao;
	
	@RequestMapping("/accountlist")
	public String viewBooklist(Model m, Customer c) {
		List<CustomerAcct> list = dao.getAccounts(c);
		System.out.print(list);
		m.addAttribute("list", list);
		return "accountlist";
	}
	
	@RequestMapping(value = "/deposit/{id}")
	public String deposit(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountlist";
	}
	
	@RequestMapping(value = "/draw/{id}")
	public String draw(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountlist";
	}
	
	@RequestMapping(value = "/transfer/{id}")
	public String transfer(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountlist";
	}


}
