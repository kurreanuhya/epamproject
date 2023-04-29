package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Admin;
import com.example.entity.User;
import com.example.services.AdminService;
import com.example.services.HomesService;
import com.example.services.ProviderService;
import com.example.services.UserService;

@Controller
public class AdmindashboardController {

	@Autowired
	private ProviderService service;
	@Autowired
	private UserService uservice;
	@Autowired
	private HomesService hservice;
	@Autowired
	private AdminService aservice;
	
	@GetMapping("/admindashboard")
	public String dashboard(HttpServletRequest request)
	{   request.setAttribute("allproviders", service.showAllProvider());
	    request.setAttribute("usercount", uservice.count());
	    request.setAttribute("providercount", service.count());
	    request.setAttribute("roomscount", hservice.countRooms());
	    request.setAttribute("villahcount", hservice.countVillah());
		return "admindashboard";
	}
	
	@GetMapping("/adminlogin")
	public String adminlogin(HttpServletRequest request)
	{ request.setAttribute("mode", "MODE_ALOGIN");
		return "adminlogin";
	}
	@RequestMapping ("/login-admin")
	public String loginUser(@ModelAttribute Admin admin, HttpServletRequest request) {
		return dashboard(request);
	}
	@GetMapping("/customerinfo")
	public String customerinfo(HttpServletRequest request)
	{   request.setAttribute("allusers",uservice.showAllUsers());
		return "customerinfo";
	}
	@GetMapping("/providerinfo")
	public String providerinfo(HttpServletRequest request)
	{   request.setAttribute("allproviders", service.showAllProvider());
	return "providerinfo";
	}
	
   
}

