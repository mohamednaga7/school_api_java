package com.mohamednagah.school_api.course.service;

import com.mohamednagah.school_api.course.dto.AddCourseDto;
import com.mohamednagah.school_api.course.dto.UpdateCourseDto;
import com.mohamednagah.school_api.course.entity.Course;
import com.mohamednagah.school_api.course.mapper.CourseMapper;
import com.mohamednagah.school_api.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public Page<Course> getCoursesList(Integer limit, Integer page) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page - 1, limit == null ? 50 : limit, Sort.by("courseName").descending());
        return this.courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> searchForCourses(String searchQuery, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page - 1, limit == null ? 50 : limit, Sort.by("courseName").descending());
        return courseRepository.searchCoursesByCourseNameLikeIgnoreCase(searchQuery, pageable);
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    @Transactional
    public Course addCourse(AddCourseDto addCourseDto) {
        Course newCourse = new Course();
        courseMapper.createCourseEntityFromDto(addCourseDto, newCourse);
        courseRepository.save(newCourse);
        return newCourse;
    }

    @Override
    @Transactional
    public Course updateCourse(String id, UpdateCourseDto updateCourseDto) {
        Course foundCourse = courseRepository.findById(id).orElseThrow();
        courseMapper.updateCourseEntityFromDto(updateCourseDto, foundCourse);
        courseRepository.save(foundCourse);
        return foundCourse;
    }

    @Override
    @Transactional
    public Boolean deleteCourse(String id) {
        Course foundCourse = courseRepository.findById(id).orElse(null);
        if (foundCourse == null) return false;
        courseRepository.delete(foundCourse);
        return true;
    }
}
