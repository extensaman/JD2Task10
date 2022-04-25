package by.it.academy;


import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.AdminServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AdminServiceTest {
    private EntityDao<Mentor> mentorEntityDao;
    private EntityDao<Course> courseEntityDao;
    AdminServiceImpl adminService;
    Mentor mentor;
    Course course;

    @Before
    public void setUp() {
        mentorEntityDao = DaoFactory.getInstance().getMentorDao();
        courseEntityDao = DaoFactory.getInstance().getCourseDao();
        adminService = new AdminServiceImpl();
        mentor = Mentor.builder().mentorName("Вася").build();
        course = Course.builder().courseProgram("new Course").build();
    }

  /*  @Test
    public void testInsertMentorToCourse() {
        adminService.createCourse(course.getCourseProgram());
        adminService.createMentor(mentor.getMentorName());
        System.out.println(course.getId());
        System.out.println(mentor.getId());
        Course course1 = courseEntityDao.findById(course.getId());
        Mentor mentor1 = mentorEntityDao.findById(mentor.getId());
        System.out.println(course1.getId());
        System.out.println(mentor1.getId());
        adminService.insertMentorToCourse(mentor1.getId(), course1.getId());
    }
    @Test
    public void testCreateMentor() {
        adminService.createMentor(mentor.getMentorName());
        assertNotNull(mentorEntityDao.findById(mentor.getId()));
    }

    @Test
    public void testCreateCourse() {
        adminService.createCourse(course.getCourseProgram());
        assertNotNull(courseEntityDao.findById(course.getId()));
    }*/

}