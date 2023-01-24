package com.mohamednagah.school_api.teacher.controller;

import com.mohamednagah.school_api.teacher.dto.CreateTeacherDto;
import com.mohamednagah.school_api.teacher.dto.UpdateTeacherDto;
import com.mohamednagah.school_api.teacher.entity.Teacher;
import com.mohamednagah.school_api.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public ResponseEntity<Page<Teacher>> getTeachers(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "limit", required = false) Integer limit) {
        return ResponseEntity.ok(teacherService.getTeachers(page, limit));
    }

    @GetMapping("{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("teacherId") String teacherId) {
        return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }

    @GetMapping("search")
    public ResponseEntity<Page<Teacher>> getTeacherByEmail(@RequestParam("query") String query, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        return ResponseEntity.ok(teacherService.searchTeachers(query, page, limit));
    }

    @PostMapping()
    public ResponseEntity<Teacher> createTeacher(@RequestBody() CreateTeacherDto createTeacherDto) {
        return ResponseEntity.ok(teacherService.createTeacher(createTeacherDto));
    }

    @PatchMapping("{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("teacherId") String teacherId, @RequestBody()UpdateTeacherDto updateTeacherDto) {
        return ResponseEntity.ok(teacherService.updateTeacherById(teacherId, updateTeacherDto));
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("teacherId") String teacherId) {
        teacherService.deleteTeacherById(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
