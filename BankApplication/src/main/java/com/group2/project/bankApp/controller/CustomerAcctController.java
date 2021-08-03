package com.group2.project.bankApp.controller;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for CustomerAccount, bridging between
 * beans / CustomerAcctDao and related views
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
import com.group2.project.bankApp.bean.CustomerAcct;
import com.group2.project.bankApp.bean.Login;
import com.group2.project.bankApp.dao.CustomerAcctDao;
import com.group2.project.bankApp.dao.CustomerDao;

import javax.servlet.http.HttpSession;


@Controller
public class CustomerAcctController {
	@Autowired
	CustomerAcctDao dao;
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value = "/accountlist", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("accountlist");
        HttpSession session = request.getSession(false);  
        String userId = (String) session.getAttribute("userId"); 
		Customer c = customerDao.getCustomerByUserId(userId);
		List<CustomerAcct> list = dao.getAccounts(c);
		mav.addObject("list", list);
		return mav;
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
	
	@RequestMapping(value = "/accountRegister", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("accountRegister");
	    mav.addObject("account", new CustomerAcct());

	    return mav;
	  }

	  @RequestMapping(value = "/accountRegisterProcess", method = RequestMethod.POST)
	  public ModelAndView addAccount(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("account") CustomerAcct c) {

	    dao.register(c);

	    return new ModelAndView("welcome", "customerId", c.getCustomerId());
	  }


}
