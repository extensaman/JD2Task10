package by.it.academy.services;

import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;

import java.util.List;

public class StudentService {

    public void joinCourse(Integer studentId, Integer courseId) {
        EntityDao<Student> studentDao = DaoFactory.getInstance().getStudentDao();
        EntityDao<Course> courseDao = DaoFactory.getInstance().getCourseDao();

        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);
        course.getStudents().add(student);
        courseDao.update(course);

        studentDao.closeDao();
        courseDao.closeDao();
    }

    public void leaveCourse(Integer studentId, Integer courseId) {
        EntityDao<Student> studentDao = DaoFactory.getInstance().getStudentDao();
        EntityDao<Course> courseDao = DaoFactory.getInstance().getCourseDao();

        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);
        List<Student> students = course.getStudents();
        students.remove(student);
        courseDao.update(course);

        studentDao.closeDao();
        courseDao.closeDao();
    }
}
