package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Homes;

public interface HomesRepository extends JpaRepository<Homes,Integer>{
	
	
    List<Homes> findByLocation(String location);
    Homes findByNameAndId(String name,int id);
    Homes findByLocationAndName(String location,String name);
    void deleteByLocation(String location);
    List<Homes> findByHometype(String hometype);
    @Query("SELECT COUNT(h) FROM Homes h where h.hometype LIKE 'Villa%'")
    int countvilla();
    @Query("SELECT COUNT(h) FROM Homes h where h.hometype NOT LIKE 'Villa%'")
    int countrooms();
}
