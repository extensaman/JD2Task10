package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntityDaoImplTest {
    EntityDao<Admin> adminEntityDao;
    Admin admin;
    List<Admin> adminList = new ArrayList<>();

    @Before
    public void setUp() {
        adminEntityDao = DaoFactory.getInstance().getAdminDao();
        admin = Admin.builder().adminName("kdjfsk").build();
        adminList.add(admin);
    }

    @Test
    public void testFindByIdAndSave() {
        adminEntityDao.save(admin);
        Admin actual = adminEntityDao.findById(admin.getId());
        assertNotNull(actual);
        assertEquals(admin, actual);
    }

    @Test
    public void testFindAllAndSaveAll() {
        adminEntityDao.save(adminList);
        List<Admin> list = adminEntityDao.findAll();
        assertArrayEquals(list.toArray(), adminList.toArray());
    }

    @Test
    public void testUpdate() {
        adminEntityDao.save(admin);
        Admin expected = adminEntityDao.findById(1);
        expected.setAdminName("skgddf;g");
        adminEntityDao.update(expected);
        Admin actual = adminEntityDao.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        adminEntityDao.save(admin);
        assertNotNull(adminEntityDao.findById(1));
        adminEntityDao.delete(admin.getId());
        //assertNull(entityDao.findById(1));
    }

    @After

    public void tearDown() {
        //HibernateUtil.close();
    }

}