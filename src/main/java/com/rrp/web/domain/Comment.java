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
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ComId;
	
	private Long onWhat;

	private String name;

	@NotNull(message = "Detail Can Not Be Empty")
	@NotEmpty(message = "Detail Can Not Be Empty")
	@Size(min = 10, message = "Detail Should Be At Least Ten Character")
	@Column(columnDefinition = "TEXT")
	private String comment;
}
