package com.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin {
	@Column(unique = true)
	private String userName;
	private String password;
	
}
