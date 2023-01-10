package com.mohamednagah.school_api.course.repository;

import com.mohamednagah.school_api.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Page<Course> searchCoursesByCourseNameLikeIgnoreCase(String searchQuery, Pageable page);

}
