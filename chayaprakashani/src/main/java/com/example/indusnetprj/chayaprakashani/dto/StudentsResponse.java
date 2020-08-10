//package com.example.indusnetprj.chayaprakashani.dto;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import com.example.indusnetprj.chayaprakashani.entity.Courses;
////import com.example.indusnetprj.chayaprakashani.entity.StudCourses;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//public class StudentsResponse {
//
//	private Integer id;
//	
//	private String firstName;
//	
//	private String lastName;
//	
//	private String email;
//	
//	private Integer courseId;
//	
//	private String courseName;
//	
//	public StudentsResponse() {
//		super();
//		
//	}
//
//	public StudentsResponse(Integer id, String firstName, String lastName, String email, Integer courseId,
//			String courseName) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.courseId = courseId;
//		this.courseName = courseName;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Integer getCourseId() {
//		return courseId;
//	}
//
//	public void setCourseId(Integer courseId) {
//		this.courseId = courseId;
//	}
//
//	public String getCourseName() {
//		return courseName;
//	}
//
//	public void setCourseName(String courseName) {
//		this.courseName = courseName;
//	}
//
//	@Override
//	public String toString() {
//		return "StudentsResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", courseId=" + courseId + ", courseName=" + courseName + "]";
//	}
//
//
//}
//	
//
