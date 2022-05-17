package by.it.academy.services;

import by.it.academy.repository.entity.Course;
import by.it.academy.services.dto.StudentDto;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    List<Course> findAllCourseWithoutMentor();
}
