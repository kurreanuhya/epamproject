package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contactus;
import com.example.repo.ContactusRepository;

@Service
public class ContactusService {

	@Autowired
	private ContactusRepository repo;
	public ContactusService(ContactusRepository repo) {
		this.repo=repo;
	}
	public void saveissue(Contactus c)
	{
		repo.save(c);
	}
}
