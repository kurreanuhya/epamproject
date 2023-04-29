package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Contactus;
import com.example.repo.HomesRepository;
import com.example.services.ContactusService;

@Controller
public class ContactusController {

	@Autowired
	private ContactusService service;
	 
	@RequestMapping("/contactus")
	public String contact(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ISSUE");
		return "contactus";
	}
	@PostMapping("/saveissue")
	public String Stateproblem(@RequestParam("email") String email,@RequestParam("name") String name,@RequestParam("subject") String subject,
			@RequestParam("message") String message){
		Contactus c=new Contactus(email,name,subject,message);
		service.saveissue(c);
		return "redirect:/";
	}
}
