package com.mohamednagah.school_api.student.repository;

import com.mohamednagah.school_api.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:searchQuery% OR s.lastName LIKE %:searchQuery% OR s.email LIKE  %:searchQuery%")
    Page<Student> searchStudents(String searchQuery, Pageable page);
}
