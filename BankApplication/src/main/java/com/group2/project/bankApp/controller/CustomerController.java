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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group2.project.bankApp.bean.Customer;
import com.group2.project.bankApp.bean.CustomerAcct;
import com.group2.project.bankApp.bean.CustomerBill;
import com.group2.project.bankApp.bean.Login;
import com.group2.project.bankApp.dao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;
	
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("editCustomer");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
        	String userId = (String) session.getAttribute("userId"); 
    		Customer c = dao.getCustomerByUserId(userId);
    		mav.addObject("command", c);
    		mav.addObject("customerId", c.getCustomerId());
    		mav.addObject("userId", c.getUserId());
//    		mav.addObject("firstName", c.getFirstName());
//    		mav.addObject("lastName", c.getLastName());
//    		mav.addObject("address", c.getAddress());
//    		mav.addObject("state", c.getState());
//    		mav.addObject("country", c.getCountry());
//    		mav.addObject("postalCode", c.getPostalCode());
    		return mav;
        }  else {
			// redirect to HomePage if user try to visit billList
			// page without successful login 
			mav = new ModelAndView("/../HomePage");
			return mav;
		}
	}

	// proceed for editing customer profile
	@RequestMapping(value = "/editCustomerProcess", method = RequestMethod.POST)
	public ModelAndView deposit(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer c) {

		ModelAndView mav = new ModelAndView("editCustomer");
		dao.updateCustomer(c);
		mav.addObject("command", c);
		mav.addObject("customerId", c.getCustomerId());
		mav.addObject("userId", c.getUserId());

		return mav;

	}

}
