package com.mohamednagah.school_api.course.entity;

import com.mohamednagah.school_api.student.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "Course")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "course_name_unique",
                        columnNames = "course_name"
                )
        }
)
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(
            name = "course_name",
            nullable = false
    )
    private String courseName;

    @ManyToMany(
            targetEntity = Student.class,
            mappedBy = "enrolledCourses"
    )
    private List<Student> enrolledStudents;
}
