package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.entity.Assessment;

import javax.persistence.EntityManager;

public class AssessmentDaoImpl extends EntityDaoImpl<Assessment> implements AssessmentDao {
    public AssessmentDaoImpl(EntityManager em) {
        super(em, Assessment.class);
    }
}
