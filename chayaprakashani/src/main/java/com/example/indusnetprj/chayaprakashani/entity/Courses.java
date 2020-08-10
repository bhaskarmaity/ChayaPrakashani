package com.example.indusnetprj.chayaprakashani.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name="Courses")
public class Courses {
	@Id
	@NotNull(message = "provide course Id")
	@Column(name = "course_id")
	private Integer courseId;
	
	
	@Column(name="course_name")
	private String courseName;
	
	
	@Column(name="course_teacher")
	private String courseTeacher;
	
	
	@Column(name="course_fee")
	private int courseFee;
	
	
	@Column(name="course_date")
	private Date courseDate;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
    private Collection<StudentDetails> studentDetails = new ArrayList<>();
//	public Courses() {
//		
//	}
//
//	public Courses(Integer courseId, String courseName, String courseTeacher, int courseFee, Date courseDate) {
//		super();
//		this.courseId = courseId;
//		this.courseName = courseName;
//		this.courseTeacher = courseTeacher;
//		this.courseFee = courseFee;
//		this.courseDate = courseDate;
//	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public Collection<StudentDetails> getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(Collection<StudentDetails> studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", courseTeacher=" + courseTeacher
				+ ", courseFee=" + courseFee + ", courseDate=" + courseDate + "]";
	}


}