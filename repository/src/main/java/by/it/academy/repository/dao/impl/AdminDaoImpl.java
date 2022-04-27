package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.AdminDao;
import by.it.academy.repository.entity.Admin;

import javax.persistence.EntityManager;

public class AdminDaoImpl extends EntityDaoImpl<Admin> implements AdminDao {
    public AdminDaoImpl(EntityManager em) {
        super(em, Admin.class);
    }
}
