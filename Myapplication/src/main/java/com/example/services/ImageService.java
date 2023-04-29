package com.example.services;
import com.example.entity.Homes;
import com.example.entity.Image;
import com.example.repo.HomesRepository;
import com.example.repo.ImageRepository;
import com.example.utils.ImageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;
    public ImageService()
    {
    	
    }
    public ImageService(ImageRepository repo) {
    	super();
    	this.repository=repo;
    }
    @Autowired
    private HomesRepository hrepo;
    public String uploadImage(String location,String homename,MultipartFile[] files) throws IOException {
        Homes hm=null;
        hm=hrepo.findByLocationAndName(location,homename);
        if(hm!=null)
        {for(MultipartFile file:files)
        	{Image image = new Image(location,homename,ImageUtils.compressImage(file.getBytes()),hm);
            repository.save(image);
        	}
        return "successful";
        }
        else
        	return "fail";
     
       }

	public List<Image> homeImages(int id)
	{
		return repository.findByHomes(id);
	}

	public List<Image> getAllImages()
	{
		return repository.findAll();
	}
    public void deleteImageByName(String name)
    {
    	repository.deleteByName(name);
    }
    public void changeImageName(Long id ,String name)
    {
    	Image im=new Image();
    	im = repository.findById(id).get();
    	im.setName(name);
    	repository.save(im); 
    }

    
}
    