package com.example.indusnetprj.chayaprakashani.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.indusnetprj.chayaprakashani.dao.ChayaPrakashaniDAO;
//import com.example.indusnetprj.chayaprakashani.dao.StudentCourseDAO;
import com.example.indusnetprj.chayaprakashani.dao.StudentDAO;
import com.example.indusnetprj.chayaprakashani.dto.CourseDTO;
import com.example.indusnetprj.chayaprakashani.dto.StudentDTO;
import com.example.indusnetprj.chayaprakashani.dto.StudentDetailsShow;

//import com.example.indusnetprj.chayaprakashani.dto.StudentsResponse;
import com.example.indusnetprj.chayaprakashani.entity.Courses;
//import com.example.indusnetprj.chayaprakashani.entity.StudCourses;
//import com.example.indusnetprj.chayaprakashani.entity.StudCourses;
import com.example.indusnetprj.chayaprakashani.entity.StudentDetails;
import com.example.indusnetprj.chayaprakashani.exception.DuplicateEntryException;
import com.example.indusnetprj.chayaprakashani.exception.ResourceNotFoundException;

@Service
public class ChayaprakashaniService {
	
	 @Autowired
	   private StudentDAO studentrepository;

		@Autowired
		private ChayaPrakashaniDAO courseRepository;
		
		
		/**** List of all courses***/
		List<StudentDTO> listsDTO;
	
//		public List<Courses> findAllCourses(){
//			return courseRepository.findAll();
//		}
		public Page<Courses> findAllByPage(Pageable pageable)
		{
		
			return courseRepository.findAll(pageable);
		}

		/***Register a student in chayaprakashani Platform ***/
//
//		public StudentDetails savestudent(StudentDetails request) throws NonUniqueResultException {
//
//	 StudentDetails existingemail = studentrepository.findByEmail(request.getEmail()).orElse(null);
//
////		StudentDetails existingpassword = studentrepository.findByPassword(request.getPassword()).orElse(null);
////
////			List<String> arr = repository.getCourses();
////
////			List<StudCourses> studCourses = request.getStudcourses();
////			for (StudCourses studCourse : studCourses) {
////				String course = studCourse.getCourseName();
////				boolean ans = arr.stream().anyMatch(course::equalsIgnoreCase);
////				if (!ans) {
////					throw new ResourceNotFoundException("Course Not Found");
////				}
////			}
//			if (existingemail != null) {
//
//				throw new NonUniqueResultException();
//			}
//
////			if (existingpassword != null) {
////
////				throw new NonUniqueResultException();
////			}
//
//			String role = request.getRoles();
//
//			if (role == null) {
//				request.setRoles("ROLE_USER");
//			}
//			return studentrepository.save(request);
//
//		}
//		public StudentDetails saveStudent(StudentDetails studentDetails) throws NonUniqueResultException {
//			StudentDetails existingEmail = studentrepository.findByEmail(studentDetails.getEmail()).orElse(null);
//
//			if (existingEmail != null) {
//
//				throw new NonUniqueResultException();
//			}
//			
//			StudentDetails existinguserId = studentrepository.findByuserId(studentDetails.getUserId()).orElse(null);
//			if(existinguserId !=null) {
//				throw new DuplicateEntryException("Duplicate entry of userId is not permissible");
//			}
//			
//			List<Integer> courseIds = courseRepository.getCourseId();
//			List<Courses> courseList = (List<Courses>) studentDetails.getCourses();
//			for (Courses course : courseList) {
//				Integer courseId = course.getCourseId();
//				boolean ans = courseIds.contains(courseId);
//				if (!ans) {
//					throw new ResourceNotFoundException("Course Not Found for course id : "+courseId);
//				}
//			}
//			StudentDetails newStudentDetails = new StudentDetails();
//			newStudentDetails.setFirstName(studentDetails.getFirstName());
//
//			newStudentDetails.setLastName(studentDetails.getLastName());
//			newStudentDetails.setUserId(studentDetails.getUserId());
//			newStudentDetails.setEmail(studentDetails.getEmail());
//			newStudentDetails.setPassword(studentDetails.getPassword());
//			newStudentDetails.setMobile(studentDetails.getMobile());
//			String role = studentDetails.getRoles();
//
//			if (role == null) {
//				newStudentDetails.setRoles("ROLE_USER");
//			}
//			newStudentDetails.getCourses().addAll(studentDetails.getCourses().stream().map(courses -> {
//				Courses course = courseRepository.findCourseByCourseId(courses.getCourseId());
//				course.getStudentDetails().add(newStudentDetails);
//				return course;
//			}).collect(Collectors.toList()));
//			return studentrepository.save(newStudentDetails);
//		}
//	
//
		
		public StudentDetails saveStudent(StudentDetails studentDetails) throws NonUniqueResultException {
//			StudentDetails existingEmail = studentrepository.findByEmail(studentDetails.getEmail()).orElse(null);
		boolean existingEmail = studentrepository.existsByEmail(studentDetails.getEmail());
		if (existingEmail) {

			throw new NonUniqueResultException();
		}

		boolean existinguserId = studentrepository.existsByUserId(studentDetails.getUserId());
		if (existinguserId) {
			throw new DuplicateEntryException("Duplicate entry of userId is not permissible");
		}

//			List<Integer> courseIds = courseRepository.getCourseId();
		List<Courses> courseList = (List<Courses>) studentDetails.getCourses();
		for (Courses course : courseList) {
			Integer courseId = course.getCourseId();
			boolean ans = courseRepository.existsByCourseId(courseId);
			if (!ans) {
				throw new ResourceNotFoundException("Course Not Found for course id : " + courseId);
			}
		}
		StudentDetails newStudentDetails = new StudentDetails();
		newStudentDetails.setFirstName(studentDetails.getFirstName());

		newStudentDetails.setLastName(studentDetails.getLastName());
		newStudentDetails.setUserId(studentDetails.getUserId());
		newStudentDetails.setEmail(studentDetails.getEmail());
		newStudentDetails.setPassword(studentDetails.getPassword());
		newStudentDetails.setMobile(studentDetails.getMobile());
		String role = studentDetails.getRoles();

		if (role == null) {
			newStudentDetails.setRoles("ROLE_USER");
		}
		newStudentDetails.getCourses().addAll(studentDetails.getCourses().stream().map(courses -> {
			Courses course = courseRepository.findCourseByCourseId(courses.getCourseId());
			course.getStudentDetails().add(newStudentDetails);
			return course;
		}).collect(Collectors.toList()));
		return studentrepository.save(newStudentDetails);
	}
		
		/*Single students details*/
		public Optional<StudentDetailsShow> getStudentByuserId(String userId) {
				
			Optional<StudentDetails> studDetails=Optional.ofNullable(studentrepository.findByuserId(userId).orElseThrow(() -> new ResourceNotFoundException("Student not found:")));
			StudentDetails stud=studDetails.get();
 

			return Optional.of(new StudentDetailsShow(stud.getFirstName(), stud.getLastName(), stud.getEmail(), 
					stud.getMobile(), stud.getCourses()));
		}
		
	
		/* Admin can show all details*/
		
		public Page<StudentDetails> getJoinInformation(Pageable pageable) {
			
			return studentrepository.getAllStudentExceptAdmin(pageable);			

	    }
		
		/*Student found by course name*/
		
		public List<StudentDTO> studentsByCourse(String courseName) {		
			
//			List<String> arr = courseRepository.getCourses();
//			
//			boolean ans = arr.stream().anyMatch(course::equalsIgnoreCase);
//			
			boolean ans = courseRepository.existsBycourseName(courseName);
			//boolean ans = courseRepository.getCourses();
			if(!ans) {
				throw new ResourceNotFoundException( "Course Not Found");
			}
			else if (studentrepository.findByCourseNameIgnoreCase(courseName).isEmpty()) {
				
			 throw new ResourceNotFoundException("No student present for this specific course/ check course name ");
						
					}
			return studentrepository.findByCourseNameIgnoreCase(courseName) ;	
		}
		
		/*counting course*/
		
		public CourseDTO getCountByCourse(String courseName) {
//			List<String> arr = courseRepository.getCourses();
//			boolean ans = arr.stream().anyMatch(courseName.trim()::equalsIgnoreCase);
			boolean ans = courseRepository.existsBycourseName(courseName);
			if(!ans) {
				throw new ResourceNotFoundException( "Course Not Found");
			}
			else if (studentrepository.findByCourseNameIgnoreCase(courseName).isEmpty()) {
				
		 throw new ResourceNotFoundException("No student present for this specific course/ check course name ");
							
				}
			return studentrepository.countByCourseNameIgnoreCase(courseName);
		}
}
