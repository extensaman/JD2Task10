package by.it.academy.repository.dao;

import by.it.academy.repository.dao.impl.AdminDaoImpl;
import by.it.academy.repository.dao.impl.AssessmentDaoImpl;
import by.it.academy.repository.dao.impl.CourseDaoImpl;
import by.it.academy.repository.dao.impl.MentorDaoImpl;
import by.it.academy.repository.dao.impl.StudentDaoImpl;
import by.it.academy.repository.dao.impl.TaskDaoImpl;

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
    public AdminDao getAdminDao() {
        return new AdminDaoImpl(factory.createEntityManager());
    }

    /**
     * @return -
     */
    public AssessmentDao getAssessmentDao() {
        return new AssessmentDaoImpl(factory.createEntityManager());
    }

    /**
     * @return -
     */
    public MentorDao getMentorDao() {
        return new MentorDaoImpl(factory.createEntityManager());
    }

    /**
     * @return -
     */
    public CourseDao getCourseDao() {
        return new CourseDaoImpl(factory.createEntityManager());
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
    public TaskDao getTaskDao() {
        return new TaskDaoImpl(factory.createEntityManager());
    }
}
