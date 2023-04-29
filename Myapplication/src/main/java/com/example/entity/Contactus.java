package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contactus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contactus {

	@Id
	private String email;
	private String name;
	private String subject;
	private String message;
	
}
