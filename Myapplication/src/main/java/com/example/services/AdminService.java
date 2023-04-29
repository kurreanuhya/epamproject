package com.example.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.entity.User;
import com.example.repo.AdminRepository;


@Service
//@Transactional
public class AdminService {
@Autowired	
private AdminRepository repo;

public AdminService(AdminRepository repo) {
	super();
	this.repo = repo;
}

public Admin findByEmailAndPassword(String email, String password) {
	return repo.findByEmailAndPassword(email, password);
}
	
}
