package by.it.academy.services;

import by.it.academy.repository.entity.Course;
import by.it.academy.services.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    List<CourseDto> findAllCourseDto();
    List<Course> findAllCourseWithoutMentor();
}
