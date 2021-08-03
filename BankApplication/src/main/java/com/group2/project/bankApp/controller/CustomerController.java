package com.group2.project.bankApp.controller;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for Customer, bridging between
 * beans / CustomerDao and related views
 * **/

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.Login;
import com.group2.project.bankApp.dao.CustomerDao;

public class CustomerController {
	@Autowired
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
	
	@RequestMapping(value = "/customerRegister", method = RequestMethod.GET)
	  public ModelAndView showInfo(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("customerRegister");
	    mav.addObject("customer", new Customer());

	    return mav;
	  }

	  @RequestMapping(value = "/customerRegisterProcess", method = RequestMethod.POST)
	  public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("customer") Customer c) {

		  dao.register(c);

	    return new ModelAndView("welcome", "firstname", c.getFirstName());
	  }

}
