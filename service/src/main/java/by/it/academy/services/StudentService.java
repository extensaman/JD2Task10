package by.it.academy.services;

import by.it.academy.repository.entity.Student;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void joinCourse(Integer studentId, Integer courseId) throws SecurityException;
    void leaveCourse(Integer studentId, Integer courseId) throws SecurityException;
    List<StudentDto> findAllStudentDto();
    List<AssessmentTdo> getListOfStudentAssessment(Integer studentId);
}
