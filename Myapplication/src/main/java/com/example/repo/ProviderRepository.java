package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider,Integer>{
    
	Provider findById(int id);
	Provider findByUsernameAndPassword(String username, String password);
	@Query("SELECT COUNT(p) FROM Provider p ")
    int countProvider();
}
