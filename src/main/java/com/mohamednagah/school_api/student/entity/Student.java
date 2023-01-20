package com.mohamednagah.school_api.student.entity;

import com.mohamednagah.school_api.course.entity.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "Student")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                )
        }
)
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @Column(
            name = "gender",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(
            name = "grade",
            nullable = false
    )
    private String grade;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            foreignKey = @ForeignKey(name = "student_course_fk"),
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, String email, Integer age, Gender gender, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public void setAge(Integer age) {
        if (age < 5) throw new IllegalArgumentException("No Student should be younger than 5 years old");
        this.age = age;
    }
}
