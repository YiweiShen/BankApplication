package com.group2.project.bankApp.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerBill;
import com.group2.project.bankApp.dao.CustomerBillDao;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for CustomerBill, bridging between
 * beans / CustomerBillDao and related views
 * **/

public class CustomterBillController {
	CustomerBillDao dao;
	
	@RequestMapping("/billList")
	public String viewBill(Model m, Customer c) {
		List<CustomerBill> list = dao.getBill(c);
		System.out.print(list);
		m.addAttribute("list", list);
		return "billList";
	}
	
	@RequestMapping(value = "/paybill", method = RequestMethod.POST)
	public String addbill(@ModelAttribute("bill") CustomerBill bill) {
		dao.add(bill);
		return "redirect:/billList";
	}

}
