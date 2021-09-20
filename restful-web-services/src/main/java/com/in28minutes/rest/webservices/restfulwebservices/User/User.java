package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user.")
@Entity
public class User {

	@Size(min=2, message="Name should have atlest 2 characters")
	@ApiModelProperty(notes="Name have atlest 2 characters")
	private String name;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Past
	@ApiModelProperty(notes="Name should have atlest 2 characters")
	private Date birthDate;
	
	protected User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate + "]";
	}

	public User(String name, Integer id, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}
	
	
	
}
