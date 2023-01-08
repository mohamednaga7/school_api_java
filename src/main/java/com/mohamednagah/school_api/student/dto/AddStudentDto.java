package com.mohamednagah.school_api.student.dto;

import com.mohamednagah.school_api.student.entity.Gender;
import lombok.Data;

@Data
public class AddStudentDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final Integer age;
    private final String grade;
}
