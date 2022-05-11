package by.it.academy;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import by.it.academy.services.impl.AdminServiceImpl;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

public class AdminServiceImplTest extends Assert {

    private static EntityDao<Mentor> mentorEntityDao;
    private static EntityDao<Course> courseEntityDao;
    private static EntityDao<Admin> adminEntityDao;
    private Scanner scanner = new Scanner(System.in);
    private AdminServiceImpl adminService = new AdminServiceImpl();
    private static Course course;
    private static Mentor mentor;

    @BeforeClass
    public static void settingTest() {
        courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        adminEntityDao =
                DaoProvider.getInstance().getAdminDao();
        AdminServiceImpl as = new AdminServiceImpl();
    }

    @Test
    public void createCourseTest() {
        course = Course.builder()
                .id(1)
                .courseProgram("JAVA")
                .build();
        adminService.createCourse("JAVA");
        Course courseDB = courseEntityDao.findById(1);
        assertEquals(courseDB, course);
        courseEntityDao.closeDao();
    }

    @Test
    public void createMentorTest() {
        mentor = Mentor.builder()
                .id(1)
                .mentorName("Grigorovich")
                .build();
        adminService.createMentor("Grigorovich");
        Mentor mentorDB = mentorEntityDao.findById(1);
        assertEquals(mentorDB, mentor);
        courseEntityDao.closeDao();
    }


}
