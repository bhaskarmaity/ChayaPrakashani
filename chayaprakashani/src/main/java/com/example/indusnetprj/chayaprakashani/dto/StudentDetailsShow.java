package com.example.indusnetprj.chayaprakashani.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import com.example.indusnetprj.chayaprakashani.entity.Courses;



public class StudentDetailsShow implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private Collection<Courses> courses = new ArrayList<>();

	public StudentDetailsShow() {
		super();
		
	}

	public StudentDetailsShow(String firstName, String lastName, String email, String mobile,
			Collection<Courses> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.courses = courses;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Collection<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDetailsShow [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", courses=" + courses + "]";
	}

}
