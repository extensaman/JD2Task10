package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.entity.Assessment;
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
                .createQuery("SELECT E.assessment from Task E WHERE E.id =:taskId");
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

}
