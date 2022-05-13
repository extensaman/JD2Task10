package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Admin;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class EntityDaoImplTest {
    EntityDao<Admin> adminEntityDao;
    Admin admin;
    List<Admin> adminList = new ArrayList<>();

    @Before
    public void setUp() {
        adminEntityDao = DaoProvider.getInstance().getAdminDao();
        admin = Admin.builder().adminName("Вася").build();
        adminList.add(admin);
    }

    /*@Test
    public void testFindByIdAndSave() {
        adminEntityDao.save(admin);
        Admin actual = adminEntityDao.findById(admin.getId());
        assertNotNull(actual);
        assertEquals(admin, actual);
        try {
            admin.setId(null);
            adminEntityDao.save(admin);
        } catch (RuntimeException e) {
            assertNotEquals("", e.getMessage());
        }

        try {
            adminEntityDao.findById(null);
        } catch (RuntimeException e) {
            assertNotEquals("", e.getMessage());
        }
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
        expected.setAdminName("Петя");
        adminEntityDao.update(expected);
        Admin actual = adminEntityDao.findById(1);
        assertEquals(expected, actual);
        try {
            expected.setId(null);
            adminEntityDao.update(expected);
        } catch (RuntimeException e) {
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void testDelete() {
        adminEntityDao.save(admin);
        assertNotNull(adminEntityDao.findById(admin.getId()));
        adminEntityDao.delete(admin.getId());
        assertNull(adminEntityDao.findById(admin.getId()));
        try {
            adminEntityDao.delete(9999);
        } catch (RuntimeException e) {
            assertNotEquals("", e.getMessage());
        }
    }*/
}