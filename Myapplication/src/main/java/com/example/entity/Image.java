package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Image")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String location;
	private String name;
	public Image(String location, String name, byte[] data, Homes homes) {
		super();
		this.location = location;
		this.name = name;
		this.data = data;
		this.homes = homes;
	}

	@Lob
	@Column(name="data",length=1000)
	private byte[] data;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homesid",referencedColumnName="id")
    private Homes homes;
    
}