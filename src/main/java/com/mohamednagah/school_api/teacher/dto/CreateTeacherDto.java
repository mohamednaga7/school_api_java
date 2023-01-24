package com.mohamednagah.school_api.teacher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTeacherDto {

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String phone;
}
