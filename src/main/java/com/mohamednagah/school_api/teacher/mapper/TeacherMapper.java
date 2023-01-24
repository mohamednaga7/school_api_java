package com.mohamednagah.school_api.teacher.mapper;

import com.mohamednagah.school_api.teacher.dto.CreateTeacherDto;
import com.mohamednagah.school_api.teacher.dto.UpdateTeacherDto;
import com.mohamednagah.school_api.teacher.entity.Teacher;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTeacherFromDto(UpdateTeacherDto dto, @MappingTarget Teacher entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void createTeacherFromDto(CreateTeacherDto dto, @MappingTarget Teacher entity);

}
