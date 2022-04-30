package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.MentorDao;
import by.it.academy.repository.entity.Mentor;

import javax.persistence.EntityManager;

public class MentorDaoImpl extends EntityDaoImpl<Mentor> implements MentorDao {
    public MentorDaoImpl(EntityManager em) {
        super(em, Mentor.class);
    }

}
