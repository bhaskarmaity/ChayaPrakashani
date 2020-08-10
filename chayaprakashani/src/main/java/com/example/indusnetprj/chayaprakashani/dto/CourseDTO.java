package com.example.indusnetprj.chayaprakashani.dto;

public class CourseDTO {

	private String courseName;
	
	private long number;

	public CourseDTO(String courseName, long number) {
		super();
		this.courseName = courseName;
		this.number = number;
	}

	public CourseDTO() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CourseDTO [courseName=" + courseName + ", number=" + number + "]";
	}
	
	
}
