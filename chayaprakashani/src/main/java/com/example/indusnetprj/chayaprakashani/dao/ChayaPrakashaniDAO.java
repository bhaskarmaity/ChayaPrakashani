package com.example.indusnetprj.chayaprakashani.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.indusnetprj.chayaprakashani.entity.Courses;
@Repository
public interface ChayaPrakashaniDAO extends JpaRepository<Courses, Integer>,PagingAndSortingRepository<Courses, Integer>{

//	@Query("SELECT count(courseName) FROM Courses WHERE EXISTS(SELECT courseName FROM Courses WHERE courseName:=course")
//	public boolean getCourses();

	public Courses findCourseByCourseId(Integer courseId);

	@Query("SELECT courseId FROM Courses")
	public List<Integer> getCourseId();
	
	Page<Courses> findAll(Pageable pageable) ;

	public boolean existsBycourseName(String courseName);

	public boolean existsByCourseId(Integer courseId);

}
