package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Provider;
import com.example.entity.User;
import com.example.services.HomesService;
import com.example.services.ProviderService;
import com.example.services.UserService;

@Controller

public class ProviderController {
	@Autowired
	ProviderService prov;
	@Autowired
	UserService uservice;
	@Autowired
	HomesService hservice;
	@RequestMapping("/providerlogin")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_PLOGIN");
		return "plogin";
	}
	@RequestMapping("/save-provider")
	public String registerProvider(@ModelAttribute Provider p, BindingResult bindingResult, HttpServletRequest request) {
		prov.saveMyProvider(p);
		request.setAttribute("mode", "MODE_PLOGIN");
		return "plogin";
	}
	@RequestMapping("/pregister")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "pregister";
	}
	@RequestMapping ("/login-provider")
	public String loginProvider(@ModelAttribute Provider user, HttpServletRequest request) {
		if(prov.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "providerindex";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_PLOGIN");
			return "plogin";
			
		}
	}
	@RequestMapping("providerindex")
	public String providerindex(HttpServletRequest request)
	{
		request.setAttribute("usercount",  uservice.count());
		request.setAttribute("roomscount", hservice.countRooms());
	    request.setAttribute("villahcount", hservice.countVillah());
	    request.setAttribute("allhomes", hservice.showAllHomes());
	    return "providerindex";
	}
	@RequestMapping("viewproviders")
	public String viewprovider(HttpServletRequest request)
	{
		request.setAttribute("prov", prov.showAllProvider());
		return "viewproviders";
	}


}
