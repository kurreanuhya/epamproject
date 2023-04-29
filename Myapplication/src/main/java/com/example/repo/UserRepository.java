package com.example.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {	
	
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int id);
	@Query("SELECT COUNT(u) FROM User u ")
     int countUsers();
}
