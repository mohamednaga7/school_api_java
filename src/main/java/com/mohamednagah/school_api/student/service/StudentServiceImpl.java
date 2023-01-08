package com.mohamednagah.school_api.student.service;

import com.mohamednagah.school_api.student.dto.AddStudentDto;
import com.mohamednagah.school_api.student.dto.UpdateStudentDto;
import com.mohamednagah.school_api.student.entity.Student;
import com.mohamednagah.school_api.student.mapper.StudentMapper;
import com.mohamednagah.school_api.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Page<Student> getStudentsList(Integer limit, Integer page) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page - 1, limit == null ? 50 : limit, Sort.by("firstName").descending().and(Sort.by("lastName").descending()));
        return this.studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> searchForStudents(String searchQuery, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page - 1, limit == null ? 50 : limit, Sort.by("firstName").descending().and(Sort.by("lastName").descending()));
        return studentRepository.searchStudents(searchQuery, pageable);
    }

    @Override
    public Student getStudentById(String studentId) {
        Optional<Student> foundStudent = this.studentRepository.findById(studentId);
        return foundStudent.orElseThrow(() -> new IllegalStateException(String.format("Student with id %s is not found", studentId)));
    }

    @Override
    @Transactional
    public Student addStudent(AddStudentDto addStudentDto) {
        Student newStudent = new Student(addStudentDto.getFirstName(), addStudentDto.getLastName(), addStudentDto.getEmail(), addStudentDto.getAge(), addStudentDto.getGender(), addStudentDto.getGrade());
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    @Transactional
    public Student updateStudent(String id, UpdateStudentDto updateStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentMapper.updateStudentFromDto(updateStudentDto, student);
        studentRepository.save(student);
        return student;
    }

    @Override
    @Transactional
    public Boolean deleteStudent(String id) {
        studentRepository.deleteById(id);
        return true;
    }
}
