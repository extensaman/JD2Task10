package by.it.academy.repository.dao;

import by.it.academy.repository.dao.impl.EntityDaoImpl;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.entity.Student;
import by.it.academy.repository.entity.Task;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoTestFactory {
    public static final String PERSISTENCE_UNIT_NAME = "test-unit";
    private final EntityManagerFactory factory;

    private static class SingletonHolder {
        private final static DaoTestFactory INSTANCE =
                new DaoTestFactory();
    }

    private DaoTestFactory() {
        factory = Persistence
                .createEntityManagerFactory(
                        PERSISTENCE_UNIT_NAME);
    }

    /**
     * @return -
     */
    public static DaoTestFactory getInstance() {
        return DaoTestFactory.SingletonHolder.INSTANCE;
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
    public EntityDao<Student> getStudentDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Student.class);
    }

    /**
     * @return -
     */
    public EntityDao<Task> getTaskDao() {
        return new EntityDaoImpl<>(factory.createEntityManager(),
                Task.class);
    }
}
