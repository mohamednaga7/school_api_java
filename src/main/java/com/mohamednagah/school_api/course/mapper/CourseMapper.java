package com.mohamednagah.school_api.course.mapper;

import com.mohamednagah.school_api.course.dto.AddCourseDto;
import com.mohamednagah.school_api.course.dto.UpdateCourseDto;
import com.mohamednagah.school_api.course.entity.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourseEntityFromDto(UpdateCourseDto dto, @MappingTarget Course entity);

    void createCourseEntityFromDto(AddCourseDto addCourseDto, @MappingTarget Course entity);

}
