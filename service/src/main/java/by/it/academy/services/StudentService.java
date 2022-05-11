package by.it.academy.services;

import by.it.academy.repository.entity.Student;

import java.util.List;

public interface StudentService {
    void joinCourse(Integer studentId, Integer courseId) throws SecurityException;
    void leaveCourse(Integer studentId, Integer courseId) throws SecurityException;
    List<Student> findAllStudent();
}
