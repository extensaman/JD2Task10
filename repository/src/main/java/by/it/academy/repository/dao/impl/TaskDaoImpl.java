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
    public List<Task> getListOfCourseTasks(String courseName) {
        Query query = entityManager
                .createQuery("SELECT E.tasks FROM Course E " +
                        "where E.courseProgram = :courseName ");
        query.setParameter("courseName", courseName);
        List<Task> tasks = query.getResultList();
        return tasks;
    }

    @Override
    public List<Task> getListOfStudentTasks(String studentName) {
        Query query = entityManager
                .createQuery("SELECT E.taskInAssessment FROM Assessment E " +
                        "where E.studentInAssessment.studentName = :studentName ");
        query.setParameter("studentName", studentName);
        List<Task> tasks = query.getResultList();
        return tasks;
    }

}
