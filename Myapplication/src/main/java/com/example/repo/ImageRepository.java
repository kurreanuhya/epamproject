package com.example.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Image;

public interface ImageRepository extends JpaRepository<Image,Long>{
	 Optional<Image> findByName(String fileName);
	 void deleteByName(String name);
	 List<Image> findByHomes(int id);	  
	  @Transactional
	  void deleteByHomesId(int id);
}
