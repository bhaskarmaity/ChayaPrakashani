package com.example.indusnetprj.chayaprakashani.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.indusnetprj.chayaprakashani.dto.CourseDTO;
import com.example.indusnetprj.chayaprakashani.dto.StudentDTO;
import com.example.indusnetprj.chayaprakashani.dto.StudentDetailsShow;
//import com.example.indusnetprj.chayaprakashani.dto.StudentsResponse;
//import com.example.indusnetprj.chayaprakashani.dto.StudentRequest;
import com.example.indusnetprj.chayaprakashani.entity.Courses;
import com.example.indusnetprj.chayaprakashani.entity.StudentDetails;
import com.example.indusnetprj.chayaprakashani.exception.ResourceNotFoundException;
//import com.example.indusnetprj.chayaprakashani.exception.ResourceNotFoundException;
import com.example.indusnetprj.chayaprakashani.service.ChayaprakashaniService;



@RestController
@RequestMapping("/courseapi")
public class ChayaPrakashaniController {

	@Autowired
	private ChayaprakashaniService chayaprakashaniService;
	
	@RequestMapping("/courses")
	public Page<Courses> fatchByPage(Pageable page)
	{
		return this.chayaprakashaniService.findAllByPage(page);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/registerStudent")
	public String addStudent(@Valid @RequestBody StudentDetails studentDetails) throws NonUniqueResultException {
		

		  chayaprakashaniService.saveStudent(studentDetails); 		
		  
		  return ("Successfully Registered:"+studentDetails.getFirstName()+" "+studentDetails.getLastName());
	}
	


	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/showstudents/{userId}")
	public Optional<StudentDetailsShow> findStudByuserId(@PathVariable String userId,Principal p) {
		
		if(userId.equals(p.getName())) 
    return chayaprakashaniService.getStudentByuserId(userId);
	
	throw new ResourceNotFoundException("not allowed");
	}

	

	
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public Page<StudentDetails> securedHello(Pageable page) {
 
		return chayaprakashaniService.getJoinInformation(page);
	
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin/{courseName}")
	public List<StudentDTO> findByCourseName(@PathVariable String courseName){

		return chayaprakashaniService.studentsByCourse(courseName);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/admin/count/{courseName}")
	public CourseDTO countByCourseName(@PathVariable String courseName) {

		return chayaprakashaniService.getCountByCourse(courseName);

	}
        
    }
	
