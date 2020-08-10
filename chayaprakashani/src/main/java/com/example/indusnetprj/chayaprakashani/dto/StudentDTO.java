package com.example.indusnetprj.chayaprakashani.dto;

public class StudentDTO  {
	
	private Integer courseId;
	
	private String courseName;
	
	private Integer studentId;
	
	private String studentName;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(Integer courseId, String courseName, Integer studentId, String studentName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
		this.studentName = studentName;
	}

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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentDTO [courseId=" + courseId + ", courseName=" + courseName + ", studentId=" + studentId
				+ ", studentName=" + studentName + "]";
	}
	
	

}
