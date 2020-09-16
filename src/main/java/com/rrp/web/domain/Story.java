package com.rrp.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	private String latitude;
	

	private String langitude;
	

	@NotNull(message = "Detail Can Not Be Empty")
	@NotEmpty(message = "Detail Can Not Be Empty")
	@Size(min = 10, message = "Detail Should Be At Least Ten Character")
	@Column(columnDefinition = "TEXT")
	private String story;
	
	private String imgPath;
	
	
	private String type;

	private String date;
	
	private int noOflikes=0;
	
	private String nameOfPlace;
	
	private String ByWhom;
}
