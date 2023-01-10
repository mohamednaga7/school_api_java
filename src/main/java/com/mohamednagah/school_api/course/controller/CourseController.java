package com.mohamednagah.school_api.course.controller;

import com.mohamednagah.school_api.course.dto.AddCourseDto;
import com.mohamednagah.school_api.course.dto.UpdateCourseDto;
import com.mohamednagah.school_api.course.entity.Course;
import com.mohamednagah.school_api.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<Course>> getCoursesList(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false) Integer page) {
        return ResponseEntity.of(Optional.of(courseService.getCoursesList(limit, page)));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody() AddCourseDto addCourseDto) {
        return ResponseEntity.of(Optional.of(courseService.addCourse(addCourseDto)));
    }

    @GetMapping("search")
    public ResponseEntity<Page<Course>> searchCourses(@RequestParam(value = "searchQuery") String searchQuery, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false) Integer page) {
        return ResponseEntity.of(Optional.of(courseService.searchForCourses(searchQuery, page, limit)));
    }

    @GetMapping(path = "{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable("courseId") String courseId) {
        return ResponseEntity.of(Optional.of(courseService.getCourseById(courseId)));
    }

    @PatchMapping(path = "{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable("courseId") String courseId, @RequestBody() UpdateCourseDto updateCourseDto) {
        return ResponseEntity.of(Optional.of(courseService.updateCourse(courseId, updateCourseDto)));
    }

    @DeleteMapping(path = "{courseId}")
    public ResponseEntity<Boolean> deleteCourseById(@PathVariable("courseId") String courseId) {
        return ResponseEntity.of(Optional.of(courseService.deleteCourse(courseId)));
    }
}
