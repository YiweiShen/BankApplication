package com.group2.project.bankApp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group2.project.bankApp.bean.Login;
import com.group2.project.bankApp.dao.CustomerDao;
import com.group2.project.bankApp.dao.LoginDao;

import javax.servlet.http.HttpSession;

/**
 * @author Chun Ting Yiu, Xutong Chen, Yiwei Shen
 * @date 31 July 2021
 * @description controller class for Login, bridging between
 * beans / LoginDao and related views
 * **/

@Controller
public class LoginController {
	@Autowired
	LoginDao dao;
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/../HomePage");
		HttpSession session = request.getSession(false);
		// this is to clear the session when logout
	    if (session != null) {
	        session.invalidate();
	    }
	    return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;

		Login l = dao.validateUser(login);

		if (null != l) {
			mav = new ModelAndView("welcome");
			mav.addObject("userId", l.getUserId());
	        HttpSession session = request.getSession();  
	        session.setAttribute("userId", l.getUserId());  
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new Login());

	    return mav;
	  }

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("user") Login login) {

		ModelAndView mav = null;
		
		if (dao.checkUserExist(login) != null) {
			mav = new ModelAndView("register");
			mav.addObject("message", "This username is taken!! Please choose another one.");
		} else {
			dao.register(login);
			customerDao.register(login);
			mav = new ModelAndView("welcome");
			mav.addObject("userId", login.getUserId());
	        HttpSession session = request.getSession();  
	        session.setAttribute("userId", login.getUserId()); 
		}
		  
	    return mav;
	  }
}
