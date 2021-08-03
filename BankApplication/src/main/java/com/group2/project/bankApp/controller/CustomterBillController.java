package com.group2.project.bankApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/paybill", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("paybill");
	    mav.addObject("bill", new CustomerBill());

	    return mav;
	  }

	  @RequestMapping(value = "/paybillProcess", method = RequestMethod.POST)
	  public ModelAndView addAccount(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("bill") CustomerBill bill) {

	    dao.add(bill);

	    return new ModelAndView("Success!", "BillerName", bill.getBillerName());
	  }

}
