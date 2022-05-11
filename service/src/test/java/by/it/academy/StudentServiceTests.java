package by.it.academy;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import by.it.academy.services.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTests {
    private static StudentServiceImpl studentService;

    @Before
    public void setUp() {
        studentService = new StudentServiceImpl();
    }

    @Test
    public void testJoinCourse() {

        EntityDao<Student> studentClean = DaoProvider.getInstance().getStudentDao();
        studentClean.findAll()
                .forEach(student -> studentClean.delete(student.getId()));
        studentClean.closeDao();

        EntityDao<Course> courseClean = DaoProvider.getInstance().getCourseDao();
        courseClean.findAll()
                .forEach(course -> courseClean.delete(course.getId()));
                        courseClean.closeDao();

        EntityDao<Course> courseDao = DaoProvider.getInstance().getCourseDao();
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();

        Course course = new Course();
        course.setCourseProgram("test");
        course.setStudents(Collections.emptyList());
        courseDao.save(course);

        Integer courseId = courseDao.findAll().iterator().next().getId();

        Student student = new Student();
        student.setStudentName("test-student");
        student.setAssessments(Collections.emptyList());
        studentDao.save(student);

        Integer studentId = studentDao.findAll().iterator().next().getId();

        studentService.joinCourse(studentId, courseId);

        studentDao.closeDao();
        courseDao.closeDao();

        courseDao = DaoProvider.getInstance().getCourseDao();

        Course updatedCourse = courseDao.findById(courseId);

        assertEquals(1, updatedCourse.getStudents().size());
        assertEquals("test-student", updatedCourse.getStudents().get(0).getStudentName());
        assertEquals(studentId, updatedCourse.getStudents().get(0).getId());
    }

    @Test
    public void testLeaveCourse() {

        EntityDao<Course> courseClean = DaoProvider.getInstance().getCourseDao();
        courseClean.findAll()
                .forEach(course -> courseClean.delete(course.getId()));
        courseClean.closeDao();

        EntityDao<Student> studentClean = DaoProvider.getInstance().getStudentDao();
        studentClean.findAll()
                .forEach(student -> studentClean.delete(student.getId()));
        studentClean.closeDao();


        EntityDao<Course> courseDao = DaoProvider.getInstance().getCourseDao();
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();

        Course course = new Course();
        course.setCourseProgram("test2");
        course.setStudents(Collections.emptyList());
        courseDao.save(course);

        Integer courseId = courseDao.findAll().iterator().next().getId();

        Student student1 = new Student();
        student1.setStudentName("test-student1");
        student1.setAssessments(Collections.emptyList());
        studentDao.save(student1);

        Student student2 = new Student();
        student2.setStudentName("test-student2");
        student2.setAssessments(Collections.emptyList());
        studentDao.save(student2);

        studentService.joinCourse(2, courseId);
        studentService.joinCourse(3, courseId);

        Integer studentId = 3;

        studentDao.closeDao();
        courseDao.closeDao();

        studentService.leaveCourse(studentId, courseId);

        courseDao = DaoProvider.getInstance().getCourseDao();
        Course updatedCourse = courseDao.findById(courseId);
        Integer studentId2 = 2;

        assertEquals(1, updatedCourse.getStudents().size());
        assertEquals("test-student1", updatedCourse.getStudents().get(0).getStudentName());
        assertEquals(studentId2, updatedCourse.getStudents().get(0).getId());
    }
}