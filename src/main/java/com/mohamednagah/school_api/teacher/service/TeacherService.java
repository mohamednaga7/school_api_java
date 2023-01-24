package com.mohamednagah.school_api.teacher.service;

import com.mohamednagah.school_api.teacher.dto.CreateTeacherDto;
import com.mohamednagah.school_api.teacher.dto.UpdateTeacherDto;
import com.mohamednagah.school_api.teacher.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    public Page<Teacher> getTeachers(Integer page, Integer limit);

    public Teacher getTeacherById(String id);

    public Page<Teacher> searchTeachers(String email, Integer page, Integer limit);

    public Teacher updateTeacherById(String id, UpdateTeacherDto updateTeacherDto);

    public Teacher createTeacher(CreateTeacherDto createTeacherDto);

    public void deleteTeacherById(String id);
}
