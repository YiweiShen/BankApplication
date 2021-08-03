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
import com.group2.project.bankApp.dao.CustomerAcctDao;
import com.group2.project.bankApp.dao.CustomerDao;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerAcctController {
	@Autowired
	CustomerAcctDao dao;

	@Autowired
	CustomerDao customerDao;

	@RequestMapping(value = "/accountList", method = RequestMethod.GET)
	public ModelAndView showAccountList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav;
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userId") != null) {
			String userId = (String) session.getAttribute("userId");
			Customer c = customerDao.getCustomerByUserId(userId);
			mav = new ModelAndView("accountList");
			List<CustomerAcct> list = dao.getAccounts(c);
			mav.addObject("list", list);
			return mav;
		} else {
			// redirect to HomePage if user try to visit accountList
			// page without successful login 
			mav = new ModelAndView("/../HomePage");
			return mav;
		}

	}

	@RequestMapping(value = "/newSavingAccount", method = RequestMethod.GET)
	public ModelAndView createNewSavingAccount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("accountList");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userId") != null) {
			String userId = (String) session.getAttribute("userId");
			Customer c = customerDao.getCustomerByUserId(userId);
			dao.cerateSavingAccount(c);
			List<CustomerAcct> list = dao.getAccounts(c);
			mav.addObject("list", list);
			return mav;
		} else {
			// redirect to HomePage if user try to visit newSavingAccount
			// page without successful login 
			mav = new ModelAndView("/../HomePage");
			return mav;
		}
	}

	@RequestMapping(value = "/newCheckingAccount", method = RequestMethod.GET)
	public ModelAndView createNewCheckingAccount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("accountList");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userId") != null) {
			String userId = (String) session.getAttribute("userId");
			Customer c = customerDao.getCustomerByUserId(userId);
			dao.cerateCheckingAccount(c);
			List<CustomerAcct> list = dao.getAccounts(c);
			mav.addObject("list", list);
			return mav;
		} else {
			// redirect to HomePage if user try to visit newCheckingAccount
			// page without successful login 
			mav = new ModelAndView("/../HomePage");
			return mav;
		}
	}

	@RequestMapping(value = "/deposit/{id}")
	public String deposit(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountList";
	}

	@RequestMapping(value = "/draw/{id}")
	public String draw(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountList";
	}

	@RequestMapping(value = "/transfer/{id}")
	public String transfer(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountList";
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
