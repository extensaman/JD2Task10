package by.it.academy.services;

import by.it.academy.repository.entity.Course;
import by.it.academy.services.dto.CourseDto;
import by.it.academy.services.dto.CourseForMentorDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAllCourse();
    List<CourseDto> findAllCourseDto();
    List<Course> findAllCourseWithoutMentor();
    void createCourse(String nameCourse);
    List<CourseForMentorDto> findAllCourseWithoutAnyMentor();
    List<CourseForMentorDto> findAllCourseForExistingMentor(Integer mentorId);
}
