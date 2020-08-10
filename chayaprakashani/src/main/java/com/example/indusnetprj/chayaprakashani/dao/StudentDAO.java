package com.example.indusnetprj.chayaprakashani.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.indusnetprj.chayaprakashani.dto.CourseDTO;
import com.example.indusnetprj.chayaprakashani.dto.StudentDTO;
import com.example.indusnetprj.chayaprakashani.entity.Courses;
import com.example.indusnetprj.chayaprakashani.entity.StudentDetails;

@Repository
public interface StudentDAO extends JpaRepository<StudentDetails, Integer>,PagingAndSortingRepository<StudentDetails, Integer>{
	

	Optional<StudentDetails> findByEmail(String email);
	
	
	@Query("select s from StudentDetails s where s.roles='ROLE_USER'")
	Page<StudentDetails> getAllStudentExceptAdmin(Pageable pageable);
	
	@Query("SELECT new com.example.indusnetprj.chayaprakashani."
			+ "dto.StudentDTO(c.courseId, c.courseName, s.id, CONCAT(s.firstName,' ',s.lastName)) "
			+ "FROM StudentDetails s JOIN s.courses c where c.courseName LIKE %?1% order by c.courseName")
	public List<StudentDTO> findByCourseNameIgnoreCase(String courseName);
	
	@Query("SELECT new com.example.indusnetprj.chayaprakashani.dto.CourseDTO(c.courseName, COUNT(s.id)) "
			+ "FROM StudentDetails s JOIN s.courses c "
			+ "where c.courseName LIKE %?1%"
			+ "GROUP BY c.courseName order by c.courseName")
	public CourseDTO countByCourseNameIgnoreCase(String courseName);


	Optional<StudentDetails> findByuserId(String userId);


	public boolean existsByEmail(String email);
	public boolean existsByUserId(String userId);


	
	

}
