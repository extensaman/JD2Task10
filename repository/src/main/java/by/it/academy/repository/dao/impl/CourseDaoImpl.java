package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

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

    @Override
    public void updateMentorInCourse(Integer id, Mentor mentorNullable) {
        Optional.ofNullable(mentorNullable)
                .ifPresent(mentor -> {
                    Course course = findById(id);
                    course.setMentorField(mentor);
                    entityManager.getTransaction().begin();
                    entityManager.merge(course);
                    entityManager.getTransaction().commit();
                });
    }
}
