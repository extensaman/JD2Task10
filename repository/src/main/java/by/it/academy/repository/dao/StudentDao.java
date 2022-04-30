package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;

import java.util.List;

public interface StudentDao extends EntityDao<Student>{
    List<Student> getStudentAcademicPerformanceList(Integer markLowBound, Integer markHighBound);
    List<Course> getCourseListOfStudent(Student student);

}
