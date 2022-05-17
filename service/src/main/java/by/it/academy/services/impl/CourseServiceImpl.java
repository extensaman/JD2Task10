package by.it.academy.services.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.entity.Course;
import by.it.academy.services.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = null;
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        courses = courseDao.findAll();
        courseDao.closeDao();
        return courses;
    }
}
