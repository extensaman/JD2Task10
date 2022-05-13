package by.it.academy.services.impl;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.StudentDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import by.it.academy.services.StudentService;
import by.it.academy.services.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentDto> findAllStudentDto() {
        List<StudentDto> result = null;
        StudentDao studentDao = DaoProvider.getInstance().getStudentDao();
        result = studentDao.findAll().stream()
                .map(StudentDto::new)
                .collect(Collectors.toList());
        studentDao.closeDao();
        return result;
    }

    public void joinCourse(Integer studentId, Integer courseId)
            throws SecurityException {
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();
        EntityDao<Course> courseDao = DaoProvider.getInstance().getCourseDao();

        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);
        course.getStudents().add(student);
        courseDao.update(course);

        studentDao.closeDao();
        courseDao.closeDao();
    }

    public void leaveCourse(Integer studentId, Integer courseId)
            throws SecurityException {
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();
        EntityDao<Course> courseDao = DaoProvider.getInstance().getCourseDao();

        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);
        List<Student> students = course.getStudents();
        students.remove(student);
        courseDao.update(course);

        studentDao.closeDao();
        courseDao.closeDao();
    }
}
