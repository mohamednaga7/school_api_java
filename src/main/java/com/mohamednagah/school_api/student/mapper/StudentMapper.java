package com.mohamednagah.school_api.student.mapper;

import com.mohamednagah.school_api.student.dto.UpdateStudentDto;
import com.mohamednagah.school_api.student.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromDto(UpdateStudentDto dto, @MappingTarget Student entity);

}
