package com.mohamednagah.school_api.teacher.service;

import com.mohamednagah.school_api.teacher.dto.CreateTeacherDto;
import com.mohamednagah.school_api.teacher.dto.UpdateTeacherDto;
import com.mohamednagah.school_api.teacher.entity.Teacher;
import com.mohamednagah.school_api.teacher.mapper.TeacherMapper;
import com.mohamednagah.school_api.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> getTeachers(Integer page, Integer limit) {
        return teacherRepository.findAll(PageRequest.of(page == null ? 0 : page - 1, limit == null ? 24 : limit, Sort.by("firstName", "lastName").descending()));
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IllegalStateException("Teacher not found"));
    }

    @Override
    public Page<Teacher> searchTeachers(String email, Integer page, Integer limit) {
        return teacherRepository.searchTeachers(email, PageRequest.of(page, limit, Sort.by("firstName", "lastName").descending()));
    }

    @Override
    public Teacher updateTeacherById(String id, UpdateTeacherDto updateTeacherDto) {
        Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(() -> new IllegalStateException("Teacher not found"));
        teacherMapper.updateTeacherFromDto(updateTeacherDto, existingTeacher);
        teacherRepository.save(existingTeacher);
        return existingTeacher;
    }

    @Override
    public Teacher createTeacher(CreateTeacherDto createTeacherDto) {
        Teacher newTeacher = new Teacher();
        teacherMapper.createTeacherFromDto(createTeacherDto, newTeacher);
        teacherRepository.save(newTeacher);
        return newTeacher;
    }

    @Override
    public void deleteTeacherById(String id) {
        teacherRepository.deleteById(id);
    }
}
