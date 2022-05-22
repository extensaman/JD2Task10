package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.MentorDao;
import by.it.academy.repository.dao.exception.EntityDaoException;
import by.it.academy.repository.entity.Mentor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.Optional;

public class MentorDaoImpl extends EntityDaoImpl<Mentor> implements MentorDao {
    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger(MentorDaoImpl.class);

    public MentorDaoImpl(EntityManager em) {
        super(em, Mentor.class);
    }

    @Override
    public void delete(Integer id) {
        try {
            Mentor mentor = findById(id);
            LOGGER.trace(getClass().getSimpleName() + " deleting " + mentor);
            if (mentor != null) {
                clearMentorCourseList(mentor);
                entityManager.getTransaction().begin();
                entityManager.remove(mentor);
                entityManager.getTransaction().commit();
            }

        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        }
    }

    @Override
    public void clearMentorCourseList(Mentor mentorWithCourseList) {
        Optional.ofNullable(mentorWithCourseList)
                .ifPresent(mentor -> {
                    mentor.getCourses().forEach(course -> {
                        course.setMentorField(null);
                        try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(course);
                            entityManager.getTransaction().commit();
                        } catch (RuntimeException e) {
                            entityManager.getTransaction().rollback();
                            throw new EntityDaoException(e);
                        }

                    });
                });
    }

    @Override
    public Optional<Mentor> findMentorById(Integer id) {
        return Optional.ofNullable(findById(id));
    }

}
