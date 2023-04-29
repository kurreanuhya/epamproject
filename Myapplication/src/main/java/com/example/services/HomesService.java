package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Homes;
import com.example.entity.User;
import com.example.repo.HomesRepository;
import com.example.repo.UserRepository;

@Service
public class HomesService {

	 @Autowired
	    private HomesRepository repo;
	 public HomesService(HomesRepository repo) {
			this.repo=repo;
		}
	 public void insertHome(Homes home) {
		 repo.save(home);
	 }
     public List<Homes> showAllHomes()
     {
    	 List<Homes> homes=new ArrayList<Homes>();
    	 for(Homes h:repo.findAll()) {
    		 homes.add(h);
    	 }
    	 return homes;
    }
     public void deleteHome(int id) {
 	   repo.deleteById(id);
 	}
    public int countVillah()
    {
    	return repo.countvilla();
    }
    public int countRooms()
    {
    	return repo.countrooms();
    }
    
   public List<Homes> showByLocation(String Location)
   {
	   return repo.findByLocation(Location);
   }
   public void delByLocation(String Location)
   {
	   repo.deleteByLocation(Location);
   }
}
