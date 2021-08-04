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
import com.group2.project.bankApp.bean.CustomerAcct;
import com.group2.project.bankApp.bean.CustomerBill;
import com.group2.project.bankApp.dao.CustomerAcctDao;
import com.group2.project.bankApp.dao.CustomerBillDao;
import com.group2.project.bankApp.dao.CustomerDao;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for CustomerBill, bridging between beans /
 *              CustomerBillDao and related views
 **/

@Controller
public class CustomerBillController {
	@Autowired
	CustomerBillDao dao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CustomerAcctDao customerAcctDao;

	// show the list of the paid bills
	@RequestMapping(value = "/billList", method = RequestMethod.GET)
	public ModelAndView showBillList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("billList");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userId") != null) {
			String userId = (String) session.getAttribute("userId");
			Customer c = customerDao.getCustomerByUserId(userId);
			List<CustomerBill> list = dao.getBill(c);
			mav.addObject("list", list);
			return mav;
		} else {
			// redirect to HomePage if user try to visit billList
			// page without successful login
			mav = new ModelAndView("/../HomePage");
			return mav;
		}
	}

	// enter a bill to pay
	@RequestMapping(value = "/payBill", method = RequestMethod.GET)
	public ModelAndView payBill(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("payBill");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userId") != null) {
			String userId = (String) session.getAttribute("userId");
			Customer c = customerDao.getCustomerByUserId(userId);
			CustomerBill bill = new CustomerBill();
			bill.setCustomerId(c.getCustomerId());
			mav.addObject("customerId", c.getCustomerId());
			mav.addObject("command", bill);
			return mav;
		} else {
			// redirect to HomePage if user try to visit payBill
			// page without successful login
			mav = new ModelAndView("/../HomePage");
			return mav;
		}
	}

	// proceed to pay the bill
	@RequestMapping(value = "/paybillProcess", method = RequestMethod.POST)
	public ModelAndView paybillProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("bill") CustomerBill bill) {

		int paymentAcctNo = Integer.valueOf(request.getParameter("paymentAcctNo"));
		ModelAndView mav = new ModelAndView("billList");
		Customer c = customerDao.getCustomerById(bill.getCustomerId());
		List<CustomerAcct> accountList = customerAcctDao.getAccounts(c);
		boolean isCustomerAccount = false;
		boolean isFundingSufficient = false;
		
		// check if the payment account number belongs to the current customer
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getAcctNo() == paymentAcctNo) {
				isCustomerAccount = true;
				break;
			}
		}
		// if the account belongs to customer, then check if its funding is sufficient
		if (isCustomerAccount) {
			CustomerAcct paymentAcct = customerAcctDao.getCustomerAccountByAcctNo(paymentAcctNo);
			if (paymentAcct.getAcctBalance() >= bill.getAmount()) {
				isFundingSufficient = true;
			}
		}

		// proceed based on the check results
		if (isCustomerAccount && isFundingSufficient) {
			CustomerAcct paymentAcct = customerAcctDao.getCustomerAccountByAcctNo(paymentAcctNo);
			dao.add(bill);
			customerAcctDao.draw(paymentAcct, bill.getAmount());
			List<CustomerBill> list = dao.getBill(c);
			mav.addObject("list", list);
			return mav;
		} else {
			mav = new ModelAndView("payBill");
			Customer acc = customerDao.getCustomerByUserId(c.getUserId());
			CustomerBill billNew = new CustomerBill();
			billNew.setCustomerId(c.getCustomerId());
			mav.addObject("customerId", acc.getCustomerId());
			mav.addObject("command", billNew);
			mav.addObject("message", "Payment Account Error!! Please double check.");
			return mav;
		}
	}
}
