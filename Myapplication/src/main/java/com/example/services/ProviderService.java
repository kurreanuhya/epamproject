package com.example.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.example.entity.Provider;
import com.example.repo.ProviderRepository;

@Service
//@Transactional
public class ProviderService {
	
	private final ProviderRepository repo;
	
	public ProviderService(ProviderRepository repo) {
		this.repo=repo;
	}
	
	public void saveMyProvider(Provider provider) {
		repo.save(provider);
	}
	public int count() {
		return repo.countProvider();
	}
	public List<Provider> showAllProvider(){
		List<Provider> providers = new ArrayList<Provider>();
		for(Provider p: repo.findAll()) {
			providers.add(p);
		}
		
		return providers;
	}
	
	public void deleteMyProvider(int id) {
		repo.deleteById(id);
	}
	
	public Provider editProvider(int id) {
		return repo.findById(id);
	}
	
	public Provider findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
	
	}

	