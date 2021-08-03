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

	// show all the account of the current customer
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

	// create a new saving account for the current customer
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

	// create a new checking account for the current customer
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

	// deposit with account id in url
	@RequestMapping(value = "/deposit/{id}")
	public String depositWithId(@PathVariable int id, Model m) {
		CustomerAcct account = dao.getCustomerAccountByAcctNo(id);
		m.addAttribute("acctNo", account.getAcctNo());
		m.addAttribute("customerId", account.getCustomerId());
		m.addAttribute("acctBalance", account.getAcctBalance());
		m.addAttribute("command", account);
		return "deposit";
	}

	// deposit without account id in url
	@RequestMapping(value = "/deposit")
	public String depositWithoutId(Model m) {
		CustomerAcct account = new CustomerAcct();
		m.addAttribute("command", account);
		return "deposit";
	}

	// proceed for deposit including validation of deposit amount
	@RequestMapping(value = "/depositProcess", method = RequestMethod.POST)
	public ModelAndView deposit(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("account") CustomerAcct account) {

		double amount = account.getAcctBalance();
		CustomerAcct originalAccount = dao.getCustomerAccountByAcctNo(account.getAcctNo());
		ModelAndView mav;

		Customer c = customerDao.getCustomerById(originalAccount.getCustomerId());

		// check if the deposit amount > 0
		if (amount > 0) {
			dao.deposit(originalAccount, amount);
			mav = new ModelAndView("accountList");
			List<CustomerAcct> list = dao.getAccounts(c);
			mav.addObject("list", list);
			return mav;
		} else {
			mav = new ModelAndView("deposit");
			CustomerAcct ac = dao.getCustomerAccountByAcctNo(originalAccount.getAcctNo());
			mav.addObject("command", ac);
			mav.addObject("customerId", ac.getCustomerId());
			mav.addObject("acctBalance", ac.getAcctBalance());
			mav.addObject("acctNo", ac.getAcctNo());
			mav.addObject("message", "Deposit amount must be greater than zero!!");
			return mav;
		}

	}

	// draw with account id in url
	@RequestMapping(value = "/draw/{id}")
	public String drawWithId(@PathVariable int id, Model m) {
		CustomerAcct account = dao.getCustomerAccountByAcctNo(id);
		m.addAttribute("acctNo", account.getAcctNo());
		m.addAttribute("customerId", account.getCustomerId());
		m.addAttribute("acctBalance", account.getAcctBalance());
		m.addAttribute("command", account);
		return "draw";
	}

	// draw without account id in url
	@RequestMapping(value = "/draw")
	public String drawWithoutId(Model m) {
		CustomerAcct account = new CustomerAcct();
		m.addAttribute("command", account);
		return "draw";
	}

	// proceed for draw including validation of draw amount
	@RequestMapping(value = "/drawProcess", method = RequestMethod.POST)
	public ModelAndView draw(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("account") CustomerAcct account) {
			
		double amount = account.getAcctBalance();
		CustomerAcct originalAccount = dao.getCustomerAccountByAcctNo(account.getAcctNo());
		ModelAndView mav;

		Customer c = customerDao.getCustomerById(originalAccount.getCustomerId());

		// check if 0 < amount < acctBalance
		if (amount > 0 && amount <= originalAccount.getAcctBalance()) {
			dao.draw(originalAccount, amount);
			mav = new ModelAndView("accountList");
			List<CustomerAcct> list = dao.getAccounts(c);
			mav.addObject("list", list);
			return mav;
		} else {
			mav = new ModelAndView("draw");
			CustomerAcct ac = dao.getCustomerAccountByAcctNo(originalAccount.getAcctNo());
			mav.addObject("command", ac);
			mav.addObject("customerId", ac.getCustomerId());
			mav.addObject("acctBalance", ac.getAcctBalance());
			mav.addObject("acctNo", ac.getAcctNo());
			mav.addObject("message", "Draw amount must be between 0 and account balance!!");
			return mav;
		}
	}

	@RequestMapping(value = "/transfer/{id}")
	public String transferWithId(@PathVariable int id, Model m) {
		CustomerAcct account = new CustomerAcct();
		account.setAcctNo(id);
		m.addAttribute("command", account);
		return "redirect:/accountList";
	}



}
