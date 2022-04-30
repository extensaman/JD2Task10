package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.entity.Course;

import javax.persistence.EntityManager;

public class CourseDaoImpl extends EntityDaoImpl<Course> implements CourseDao {
    public CourseDaoImpl(EntityManager em) {
        super(em, Course.class);

    }
}
