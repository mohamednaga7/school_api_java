package com.mohamednagah.school_api.student.controller;

import com.mohamednagah.school_api.student.dto.AddStudentDto;
import com.mohamednagah.school_api.student.dto.UpdateStudentDto;
import com.mohamednagah.school_api.student.entity.Student;
import com.mohamednagah.school_api.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getStudentsList(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false) Integer page) {
        return ResponseEntity.of(Optional.of(studentService.getStudentsList(limit, page)));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody() AddStudentDto addStudentDto) {
        return ResponseEntity.of(Optional.of(studentService.addStudent(addStudentDto)));
    }

    @GetMapping("search")
    public ResponseEntity<Page<Student>> searchStudents(@RequestParam(value = "searchQuery") String searchQuery, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "page", required = false) Integer page) {
        return ResponseEntity.of(Optional.of(studentService.searchForStudents(searchQuery, page, limit)));
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") String studentId) {
        return ResponseEntity.of(Optional.of(studentService.getStudentById(studentId)));
    }

    @PatchMapping(path = "{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") String studentId, @RequestBody() UpdateStudentDto updateStudentDto) {
        return ResponseEntity.of(Optional.of(studentService.updateStudent(studentId, updateStudentDto)));
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable("studentId") String studentId) {
        return ResponseEntity.of(Optional.of(studentService.deleteStudent(studentId)));
    }
}
