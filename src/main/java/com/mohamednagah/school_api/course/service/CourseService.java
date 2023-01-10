package com.mohamednagah.school_api.course.service;

import com.mohamednagah.school_api.course.dto.AddCourseDto;
import com.mohamednagah.school_api.course.dto.UpdateCourseDto;
import com.mohamednagah.school_api.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface CourseService {
    Page<Course> getCoursesList(Integer limit, Integer page);
    Page<Course> searchForCourses(String searchQuery, Integer page, Integer limit);
    Course getCourseById(String studentId);
    Course addCourse(AddCourseDto addCourseDto);
    Course updateCourse(String id, UpdateCourseDto updateCourseDto);
    Boolean deleteCourse(String id);
}
