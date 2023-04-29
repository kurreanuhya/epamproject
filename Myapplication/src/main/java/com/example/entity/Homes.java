package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Homes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Homes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	private String hometype;
	private double rent;
	private String size;
	private String location;
	private String name;
	private String facilities;
	
	public Homes(String hometype, double rent, String size, String location, String name,
			String facilities) {
		super();
		
		this.hometype = hometype;
		this.rent = rent;
		this.size = size;
		this.location = location;
		this.name = name;
		this.facilities = facilities;
	}

	@OneToMany(mappedBy="homes",cascade=CascadeType.ALL)
	private List<Image> images;
	
}
