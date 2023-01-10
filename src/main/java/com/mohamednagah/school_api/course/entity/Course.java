package com.mohamednagah.school_api.course.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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



}
