package by.it.academy.services;

import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void createStudent(String studentName) throws SecurityException;

    void deleteStudent(Integer studentId) throws SecurityException;

    void joinCourse(Integer studentId, Integer courseId) throws SecurityException;

    void leaveCourse(Integer studentId, Integer courseId) throws SecurityException;

    List<StudentDto> findAllStudentDto();

    List<AssessmentTdo> getListOfStudentAssessment(Integer studentId);
}
