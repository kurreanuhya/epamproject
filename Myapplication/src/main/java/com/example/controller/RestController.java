package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.entity.Homes;
import com.example.entity.Provider;
import com.example.entity.User;
import com.example.services.HomesService;
import com.example.services.ProviderService;
import com.example.services.UserService;

@org.springframework.web.bind.annotation.RestController

public class RestController {
	
	@Autowired
	private UserService userService;
	@Autowired
    private ProviderService providerservice;
	@Autowired
    private HomesService homeservice;
	
	@GetMapping("/saveuser")
	@ResponseBody
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
		User user = new User(username, firstname, lastname, age, password);
		userService.saveMyUser(user);
		return "User Saved";
	}
	@GetMapping("/saveprovider")
	@ResponseBody
	public String saveProvider(@RequestParam int id,@RequestParam String username, @RequestParam String name, @RequestParam String mbl, @RequestParam int age, @RequestParam String password,@RequestParam String location) {
		Provider p= new Provider(id,username, name, mbl, age, password,location);
		providerservice.saveMyProvider(p);
		return "User Saved";
	}
	@GetMapping("/saveHome")
	@ResponseBody
	public String saveHome(@RequestParam String hometype, @RequestParam double rent, @RequestParam String size, @RequestParam String location, @RequestParam String address,String facilities) {
	    Homes h=new Homes(hometype,rent,size,location,address,facilities);
		homeservice.insertHome(h);
		return "Home Saved";
	}

}
