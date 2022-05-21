package by.it.academy.services.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.services.CourseService;
import by.it.academy.services.dto.CourseDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = null;
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        courses = courseDao.findAll();
        courseDao.closeDao();
        return courses;
    }
    @Override
    public List<CourseDto> findAllCourseDto() {
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        List<CourseDto> courses = null;
        courses = courseDao.findAll()
                .stream()
                .map(CourseDto::new)
                .collect(Collectors.toList());
        courseDao.closeDao();
        return courses;
    }

    @Override
    public List<Course> findAllCourseWithoutMentor() {
        return findAllCourse().stream()
                .filter(course -> course.getMentorField() == null)
                .collect(Collectors.toList());
    }

    @Override
    public void createCourse(String nameCourse) {
        EntityDao<Course> courseEntityDao = DaoProvider.getInstance().getCourseDao();
        Course newCourse = Course.builder()
                .courseProgram(nameCourse)
                .build();
        courseEntityDao.save(newCourse);
        courseEntityDao.closeDao();
    }

    @Override
    public Optional<Course> findCourseById(Integer id) {
        Course course;
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        course = courseDao.findById(id);
        courseDao.closeDao();
        return Optional.ofNullable(course);
    }
}
