package com.students.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class Student {
	
	
	private int id;
	
	@Pattern(regexp="[A-z]+", message="{error.student.firstname.pattern}")
//	@NotEmpty(message="Firstname cannot be empty")
	private String firstName ;
	
	@Pattern(regexp="[A-z]+", message="{error.student.lastname.pattern}")
//	@Size(min=1,message="Lastname cannot be empty")
 	private  String lastName;
	
	@Email(message="{error.student.email.valid}")
	@Size(min=1,message="{error.student.email.empty}")
 	private String email;
	
	@NotNull(message="{error.student.gender.notnull}")
 	private String gender;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull(message="{error.student.birthday.notnull}") @Past(message="{error.student.birthday.past}")
    private Date birthday;
    
    @Valid
	private Phone phone;

  	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}	
	   	
	   

}
