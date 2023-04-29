package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.services.UserService;

@Controller

public class ApplicationController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String hello() {
		return "indexlandup";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/rooms")
	public String rooms() {
		return "rooms";
	}
	@GetMapping("/roomsview")
	public String roomsview() {
		return "roomsview";
	}
	@GetMapping("/guides")
	public String guides() {
		return "guidesinfo";
	}
	@GetMapping("/roomsdetails")
	public String roomsdetails() {
		return "roomsdetails";
	}
	@GetMapping("/check")
	public String check() {
		return "checkava";
	}

	@GetMapping("/restaurants")
	public String restaurants() {
		return "restaurant";
	}
	@GetMapping("/villas")
	public String villas() {
		return "villas";
	}
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "register";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
		
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_LOGIN");
		return "login";
	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "login";
	}
	@RequestMapping("/aboutus")
	public String aboutUs() {
		return "aboutus";
	}
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "index";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "login";
			
		}
	}

}
