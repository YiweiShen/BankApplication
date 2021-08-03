package com.group2.project.bankApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerBill;
import com.group2.project.bankApp.dao.CustomerBillDao;
import com.group2.project.bankApp.dao.CustomerDao;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for CustomerBill, bridging between
 * beans / CustomerBillDao and related views
 * **/

@Controller
public class CustomerBillController {
	@Autowired
	CustomerBillDao dao;
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value = "/billList", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("billList");
        HttpSession session = request.getSession(false);  
        String userId = (String) session.getAttribute("userId"); 
		Customer c = customerDao.getCustomerByUserId(userId);
		List<CustomerBill> list = dao.getBill(c);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/payBill", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("payBill");
	    
        HttpSession session = request.getSession(false);  
        String userId = (String) session.getAttribute("userId"); 
		Customer c = customerDao.getCustomerByUserId(userId);
		
		mav.addObject("customerId", c.getCustomerId());
	    mav.addObject("bill", new CustomerBill());

	    return mav;
	  }

	  @RequestMapping(value = "/paybillProcess", method = RequestMethod.POST)
	  public ModelAndView addAccount(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("bill") CustomerBill bill) {

	        HttpSession session = request.getSession(false);  
	        String userId = (String) session.getAttribute("userId"); 
			Customer c = customerDao.getCustomerByUserId(userId);
	    dao.add(bill, c);

	    return new ModelAndView("Success!", "BillerName", bill.getBillerName());
	  }

}
