package com.mohamednagah.school_api.teacher.repository;

import com.mohamednagah.school_api.teacher.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Query("SELECT t FROM Teacher t WHERE t.firstName LIKE %:searchQuery% OR t.lastName LIKE %:searchQuery% OR t.email LIKE  %:searchQuery%")
    Page<Teacher> searchTeachers(String searchQuery, Pageable page);
}
