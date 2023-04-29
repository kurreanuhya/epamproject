package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Homes;
import com.example.entity.Provider;
import com.example.repo.HomesRepository;
import com.example.services.HomesService;

@Controller
public class HomesController {
    @Autowired
    private HomesService service;
   
    @RequestMapping("/addhome")
    public String addHome(HttpServletRequest request)
    {
    	request.setAttribute("mode", "MODE_ADDHOME");
    	return "homesave";
    }
    @PostMapping("save-home")
    public String saveNewHome(@RequestParam("hometype")String hometype,@RequestParam("rent")double rent,@RequestParam("area")String area,@RequestParam("location")String location,@RequestParam("homename")String homename,@RequestParam("facilities")String facilities)
    {
    	Homes home=new Homes(hometype,rent,area,location,homename,facilities);
    	service.insertHome(home);
		
		return "redirect:/providerindex";
    }
    @GetMapping("/homesview")
    public String viewHomes(HttpServletRequest request)
    {
    	request.setAttribute("allhomes", service.showAllHomes());
    	 return "viewhome";
    	
    }
    
//    @GetMapping("/view")
//    public String viewHomesByType(@RequestParam(name="hometype",defaultValue="all") String hometype)
//    {   
//    	return "filter";
//    }
    
    
}
