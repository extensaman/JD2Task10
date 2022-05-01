package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Task;
import by.it.academy.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TaskDaoImpl extends EntityDaoImpl<Task> implements TaskDao {

    public TaskDaoImpl(EntityManager em) {
        super(em, Task.class);
    }

    @Override
    public List<Task> getListOfCourseTasks(Integer courseId) {
        Query query = entityManager
                .createQuery("SELECT E.tasks FROM Course E " +
                        "where E.id = :courseId ");
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }

    @Override
    public List<Task> getListOfStudentTasks(Integer studentId) {
        Query query = entityManager
                .createQuery("SELECT E.taskInAssessment FROM Assessment E " +
                        "where E.studentInAssessment.id = :studentId ");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

}
