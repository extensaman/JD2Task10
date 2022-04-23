package by.it.academy.repository.dao.impl;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.util.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EntityDaoImplTest {
    EntityDaoImpl<Admin> entityDao;
    Admin admin;
    List<Admin> adminList = new ArrayList<>();

    @Before
    public void setUp() {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManager().getEntityManagerFactory();
        entityDao = new EntityDaoImpl<>(entityManagerFactory, Admin.class);
        admin = Admin.builder().adminName("kdjfsk").build();
        adminList.add(admin);
    }

    @Test
    public void testFindByIdAndSave() {
        entityDao.save(admin);
        Admin actual = entityDao.findById(admin.getId());
        assertNotNull(actual);
        assertEquals(admin, actual);
    }

    @Test
    public void testFindAllAndSaveAll() {
        entityDao.save(adminList);
        List<Admin> list = entityDao.findAll();
        assertArrayEquals(list.toArray(), adminList.toArray());
    }

    @Test
    public void testUpdate() {
        entityDao.save(admin);
        Admin expected = entityDao.findById(1);
        expected.setAdminName("skgddf;g");
        entityDao.update(expected);
        Admin actual = entityDao.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        entityDao.save(admin);
        assertNotNull(entityDao.findById(1));
        entityDao.delete(admin.getId());
        //assertNull(entityDao.findById(1));
    }

    @After

    public void tearDown() {
        //HibernateUtil.close();
    }

}