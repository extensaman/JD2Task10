package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.AdminDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AdminDaoImpl extends EntityDaoImpl<Admin> implements AdminDao {
    public AdminDaoImpl(EntityManager em) {
        super(em, Admin.class);

    }

    @Override
    public List<Course> showAllCourseAdmin(Integer adminId) {
        Query query = entityManager.createQuery(
                "SELECT co " +
                        "FROM Course  AS co " +
                        "join Admin as ad " +
                        "where " +
                        "ad.id = :adminId");
        query.setParameter("adminId", adminId);
        return query.getResultList();
    }

    @Override
    public List<Mentor> showAllMentorAdmin(Integer mentorId) {
        Query query = entityManager.createQuery(
                "SELECT me " +
                        "FROM Mentor  AS me " +
                        "join Admin as ad " +
                        "where " +
                        "ad.id = :mentorId");
        query.setParameter("mentorId", mentorId);
        return query.getResultList();
    }

}
