package com.packt.webstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	 
	@Pattern(regexp="[A-z]+",message="FirstName Cannot be empty")
	private String firstName;
	
	@Pattern(regexp="[A-z]+",message="LastName Cannot be empty")
	private String lastName;
	
	@NotNull(message= "Age cannot be empty")
	private long age;
	
	private String eyeColor;
	
	public long getId() {
		return ID;
	}
	public void setId(long id) {
		this.ID = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
}
