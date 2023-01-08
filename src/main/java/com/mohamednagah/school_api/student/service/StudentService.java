package com.mohamednagah.school_api.student.service;

import com.mohamednagah.school_api.student.dto.AddStudentDto;
import com.mohamednagah.school_api.student.dto.UpdateStudentDto;
import com.mohamednagah.school_api.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface StudentService {
    Page<Student> getStudentsList(Integer limit, Integer page);
    Page<Student> searchForStudents(String searchQuery, Integer page, Integer limit);
    Student getStudentById(String studentId);
    Student addStudent(AddStudentDto addStudentDto);
    Student updateStudent(String id, UpdateStudentDto updateStudentDto);
    Boolean deleteStudent(String id);
}
