package com.mohamednagah.school_api.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mohamednagah.school_api.student.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStudentDto {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Integer age;
    private String grade;
}