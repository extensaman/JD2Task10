package by.it.academy.repository.dao;

import by.it.academy.repository.dao.impl.EntityDaoImpl;
import by.it.academy.repository.dao.impl.StudentDaoImpl;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.entity.Student;
import by.it.academy.repository.entity.Task;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {
    public static final String PERSISTENCE_UNIT_NAME = "unit";
    private final EntityManagerFactory factory;

    private static class SingletonHolder {
        private final static DaoFactory INSTANCE =
                new DaoFactory();
    }

    private DaoFactory() {
        factory = Persistence
                .createEntityManagerFactory(
                        PERSISTENCE_UNIT_NAME);
    }

    /**
     * @return -
     */
    public static DaoFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return -
     */
    public EntityDao<Admin> getAdminDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Admin.class);
    }

    /**
     * @return -
     */
    public EntityDao<Assessment> getAssessmentDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Assessment.class);
    }

    /**
     * @return -
     */
    public EntityDao<Mentor> getMentorDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Mentor.class);
    }

    /**
     * @return -
     */
    public EntityDao<Course> getCourseDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Course.class);
    }

    /**
     * @return -
     */
    public StudentDao getStudentDao() {
        return new StudentDaoImpl(factory.createEntityManager());
    }

    /**
     * @return -
     */
    public EntityDao<Task> getTaskDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Task.class);
    }
}
