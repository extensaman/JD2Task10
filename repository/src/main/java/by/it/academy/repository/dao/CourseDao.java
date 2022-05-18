package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import java.util.Optional;

public interface CourseDao extends EntityDao<Course> {
    Optional<Course> findCourseById(Integer id);
    void updateMentorInCourse(Integer id, Mentor mentorNullable);
}
