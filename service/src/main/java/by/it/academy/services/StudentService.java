package by.it.academy.services;

public interface StudentService {
    void joinCourse(Integer studentId, Integer courseId) throws SecurityException;
    void leaveCourse(Integer studentId, Integer courseId) throws SecurityException;
}
