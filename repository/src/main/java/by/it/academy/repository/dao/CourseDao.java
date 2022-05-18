package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Course;

import java.util.Optional;

public interface CourseDao extends EntityDao<Course> {
    Optional<Course> findCourseById(Integer id);
}
