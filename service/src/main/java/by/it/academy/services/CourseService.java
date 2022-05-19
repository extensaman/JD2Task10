package by.it.academy.services;

import by.it.academy.repository.entity.Course;
import by.it.academy.services.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> findCourseById(Integer id);
    List<Course> findAllCourse();
    List<CourseDto> findAllCourseDto();
    List<Course> findAllCourseWithoutMentor();
    void createCourse(String nameCourse);

}
