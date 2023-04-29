package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Admin;
import com.example.entity.Homes;

public interface AdminRepository extends JpaRepository<Admin,String>{

	Admin findByEmailAndPassword(String email,String password);
}
