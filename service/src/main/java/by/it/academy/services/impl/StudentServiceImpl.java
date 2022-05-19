package by.it.academy.services.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.StudentDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import by.it.academy.services.StudentService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public void createStudent(String studentName)
            throws SecurityException {
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();

        Student student = Student.builder()
                .studentName(studentName)
                .build();

        studentDao.save(student);
        studentDao.closeDao();
    }

    @Override
    public void deleteStudent(Integer studentId)
            throws SecurityException {
        EntityDao<Student> studentDao = DaoProvider.getInstance().getStudentDao();

        Student student = studentDao.findById(studentId);
        studentDao.delete(student.getId());

        studentDao.closeDao();
    }

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

    @Override
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

    @Override
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

    @Override
    public List<AssessmentTdo> getListOfStudentAssessment(Integer studentId) {
        AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();
        List<AssessmentTdo> assessments = null;
        assessments = assessmentDao.getListOfStudentAssessment(studentId)
                .stream().map(AssessmentTdo::new).collect(Collectors.toList());
        assessmentDao.closeDao();
        return assessments;
    }
}
