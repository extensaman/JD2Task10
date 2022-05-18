package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CourseDaoImpl extends EntityDaoImpl<Course> implements CourseDao {
    public CourseDaoImpl(EntityManager em) {
        super(em, Course.class);

    }

    @Override
    public Optional<Course> findCourseById(Integer id) {
        return Optional.ofNullable(findById(id));
    }
}
