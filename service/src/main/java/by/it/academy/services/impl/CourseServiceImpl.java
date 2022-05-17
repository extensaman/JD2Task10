package by.it.academy.services.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.entity.Course;
import by.it.academy.services.CourseService;

import java.util.List;
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
    public List<Course> findAllCourseWithoutMentor() {
        return findAllCourse().stream()
                .filter(course -> course.getMentorField() == null)
                .collect(Collectors.toList());
    }
}
