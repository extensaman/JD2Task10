package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.*;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import by.it.academy.repository.entity.Task;
import by.it.academy.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AssessmentDaoImpl extends EntityDaoImpl<Assessment> implements AssessmentDao {
    public AssessmentDaoImpl(EntityManager em) {
        super(em, Assessment.class);

    }

    @Override
    public List<Assessment> getListOfTaskAssessment(Integer taskId) {
        Query query = entityManager
                .createQuery("SELECT E from Assessment E WHERE E.taskInAssessment.id =:taskId");
        query.setParameter("taskId",taskId);
        return query.getResultList();
    }

    @Override
    public List<Assessment> getListOfStudentAssessment(Integer studentId) {
        Query query = entityManager
                .createQuery("select E.assessments from Student E WHERE E.id = :studentId");
        query.setParameter("studentId", studentId);
        return  query.getResultList();
    }

    public static void main(String[] args) {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        StudentDao studentDao = DaoProvider.getInstance().getStudentDao();
        AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();
        Task task = taskDao.findById(2);
        Student student = studentDao.findById(1);
        Assessment assessment = Assessment.builder()
                .taskInAssessment(task)
                /*.studentInAssessment(student)*/.build();
        assessmentDao.save(assessment);

    }

}
