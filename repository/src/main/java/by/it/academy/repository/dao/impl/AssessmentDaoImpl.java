package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.entity.Assessment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AssessmentDaoImpl extends EntityDaoImpl<Assessment> implements AssessmentDao {

    public static final String TASK_ID = "taskId";
    public static final String STUDENT_ID = "studentId";
    public AssessmentDaoImpl(EntityManager em) {
        super(em, Assessment.class);
    }

    @Override
    public List<Assessment> getListOfTaskAssessment(Integer taskId) {
        Query query = entityManager
                .createQuery("SELECT E from Assessment E WHERE E.taskInAssessment.id =:taskId");
        query.setParameter(TASK_ID, taskId);
        return query.getResultList();
    }

    @Override
    public List<Assessment> getListOfStudentAssessment(Integer studentId) {
        Query query = entityManager
                .createQuery("select E.assessments from Student E WHERE E.id = :studentId");
        query.setParameter(STUDENT_ID, studentId);
        return query.getResultList();
    }
}
