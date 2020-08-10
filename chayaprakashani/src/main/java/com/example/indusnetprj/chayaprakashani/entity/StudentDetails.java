package com.example.indusnetprj.chayaprakashani.entity;

import java.util.ArrayList;

import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="student_details")
public class StudentDetails {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentid_generator")
	@SequenceGenerator(name = "studentid_generator", allocationSize = 1,sequenceName = "studentid_seq")
	@Column(name = "student_id")
	private Integer id;
	
	@NotNull(message = "Fisrt name can not be null")
	@Size(min = 2,message = "Fisrt Name must not be less than 2 char")
	@Column(name = "first_name")
	private String firstName;
	
	
	@NotBlank(message = "Last name can not be null")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email can not be null")
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+",message = "provide a valid mail id example=abc142@gmail.com" )
	@Column(name = "email")
	private String email;
	
	//(?i)-case-insensitive
	@NotNull(message = "User Id can not be null")
	@Pattern(regexp = "(?i)^(?=.*[a-z])[a-z0-9]{8,16}$",message = "length must be 8-16 char,"
			+ "consisting of  both letters and numerals&case-insensitive")
	@Column(name= "user_Id",unique = true)
	private String userId;
	
	@NotNull(message = "Password can not be null")
	@Size(min = 4,max = 8,message = "password must not be less than 4 digit")
	@Column(name = "password")
	private String password;
	
	@NotNull(message = "Mobile no can not be null")
	@Pattern(regexp = "^[6-9][0-9]{9}$",message = "Provide a valid Number")
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "roles")
	 private String roles;
	  
	
//	@NotNull(message = "Student courses can't be null")
//	@OneToMany(targetEntity = StudCourses.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "studcourseId_fk",referencedColumnName = "student_id")
//	@Valid
//	private List<StudCourses> studcourses;

	@ManyToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL)
	private Collection<Courses> courses = new ArrayList<>();

	 public StudentDetails() {
		
	}


	public StudentDetails(StudentDetails users) {
	    	
	        this.email = users.getEmail();
	        this.roles = users.getRoles();
	        this.firstName = users.getFirstName();
	        this.lastName =users.getLastName();
	        this.id = users.getId();
	        this.password = users.getPassword();
	        this.userId=users.getUserId();
		}



	public StudentDetails(Integer id,
			@NotNull(message = "Fisrt name can not be null") @Size(min = 2, message = "Fisrt Name must not be less than 2 char") String firstName,
			@NotBlank(message = "Last name can not be null") String lastName,
			@NotBlank(message = "Email can not be null") @Email String email,
			@NotNull(message = "User Id can not be null") @Pattern(regexp = "(?i)^(?=.*[a-z])[a-z0-9]{8,16}$", message = "length must be 8-16 char,consisting of  both letters and numerals&case-insensitive") String userId,
			@NotNull(message = "Password can not be null") @Size(min = 4, max = 8, message = "password must not be less than 4 digit") String password,
			@NotNull(message = "Mobile no can not be null") @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Provide a valid Number") String mobile,
			String roles, Collection<Courses> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.password = password;
		this.mobile = mobile;
		this.roles = roles;
		this.courses = courses;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public Collection<Courses> getCourses() {
		return courses;
	}


	public void setCourses(Collection<Courses> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userId=" + userId + ", password=" + password + ", mobile=" + mobile + ", roles=" + roles
				+ ", courses=" + courses + "]";
	}
	
	
	}
