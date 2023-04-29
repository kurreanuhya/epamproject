package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Image;
import com.example.services.ImageService;


@Controller

public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@GetMapping("/displayimages")
	public String showExampleView(Model model)
	{
		List<Image> images = service.getAllImages();
		model.addAttribute("images", images);
		return "displayimages";
	}
    @GetMapping("/providerupload")
    public String showAddPr()
    {
    	
    	return "upload";
    }
    @GetMapping("/retrive")
    public List<Image> getImages(@RequestParam("homesId")int id)
    {
    	return service.homeImages(id);
    }
    @PostMapping("/upload-image")
    public String uploadImages(@RequestParam("data") MultipartFile[] files,@RequestParam("location")String location,@RequestParam("name")String homename) throws IOException {
		
		 String res=service.uploadImage(location,homename,files);
		
		if(res=="successful")
			return "redirect:/providerindex";
		else
			return "upload";
	}
    
    @GetMapping("/deleteImage/{name}")
    public String deleteImage(@PathVariable("name") String name)
    {
    	
    	service.deleteImageByName(name);
    	return "redirect:/";
    }
    
    @PostMapping("/changeName")
    public String changeName(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	service.changeImageName(id, name);
    	return "redirect:/";
    }
   
  
}