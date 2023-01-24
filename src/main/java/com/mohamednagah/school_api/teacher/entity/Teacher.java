package com.mohamednagah.school_api.teacher.entity;

import com.mohamednagah.school_api.course.entity.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "Teacher")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_teacher_email", columnNames = "email")
        }
)
@NoArgsConstructor
@Getter
@Setter
public class Teacher {

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
            name = "phone",
            nullable = false
    )
    private String phone;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            foreignKey = @ForeignKey(name = "teacher_course_fk"),
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> courses;

    public Teacher(String firstName, String lastName, String email, String phone, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }
}
