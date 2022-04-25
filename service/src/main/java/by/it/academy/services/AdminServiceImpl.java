package by.it.academy.services;

import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    /**
     *
     */
    private static EntityDao<Mentor> mentorEntityDao = null;
    /**
     *
     */
    private static EntityDao<Course> courseEntityDao = null;
    /**
     *
     */
    private static EntityDao<Admin> adminEntityDao = null;
    /**
     *
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     */
    @Override
    public void createCourse(String nameCourse) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        Course course = Course.builder()
                .courseProgram(nameCourse)
                .build();
        courseEntityDao.save(course);
        courseEntityDao.closeDao();
    }

    /**
     * @param idCourse
     */
    @Override
    public void deleteCourseById(int idCourse) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        List<Course> listCourse = courseEntityDao.findAll();
        for (int i = 0; i < listCourse.size(); i++) {
            System.out.println((listCourse.get(i)).toString());
        }
        System.out.println(
                "Choose id of a mentor which do you prefer dismiss:");

        if (courseEntityDao.findById(idCourse) != null) {
            courseEntityDao.delete(idCourse);
            System.out.println("Course deleted with a input id.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void deleteCourseByName() {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        List<Course> listCourse = courseEntityDao.findAll();
        for (int i = 0; i < listCourse.size(); i++) {
            System.out.println((listCourse.get(i)).toString());
        }
        System.out.println(
                "Choose id of a course which do you prefer dismiss:");

        int idCourse = scanner.nextInt();

        if (courseEntityDao.findById(idCourse) != null) {
            courseEntityDao.delete(idCourse);
            System.out.println("Course deleted.");
        }

        courseEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void createMentor(String nameMentor) {
        mentorEntityDao =
                DaoFactory.getInstance().getMentorDao();
        Mentor mentor = Mentor.builder()
                .mentorName(nameMentor)
                .build();
        mentorEntityDao.save(mentor);
        mentorEntityDao.closeDao();
    }

    /**
     * @param idMentor
     */
    @Override
    public void deleteMentorById(int idMentor) {
        mentorEntityDao =
                DaoFactory.getInstance().getMentorDao();
        if (mentorEntityDao.findById(idMentor) != null) {
            mentorEntityDao.delete(idMentor);
            System.out.println("Mentor deleted with a input id.");
        } else {
            System.out.println("Mentor doesn't exist!");
        }
        mentorEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void deleteMentorByName() {
        mentorEntityDao =
                DaoFactory.getInstance().getMentorDao();
        List<Mentor> listMentor = mentorEntityDao.findAll();
        for (int i = 0; i < listMentor.size(); i++) {
            System.out.println((listMentor.get(i)).toString());
        }
        System.out.println(
                "Choose id of a mentor which do you prefer dismiss:");
        int idMentor = scanner.nextInt();
        if (mentorEntityDao.findById(idMentor) != null) {
            mentorEntityDao.delete(idMentor);
            System.out.println("Mentor deleted.");
        }
        mentorEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void insertMentorToCourse(int idCourse, int idMentor) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        mentorEntityDao =
                DaoFactory.getInstance().getMentorDao();
        if (courseEntityDao.findById(idCourse) != null
                && mentorEntityDao.findById(idMentor) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Mentor mentor = mentorEntityDao.findById(idMentor);
            course.setMentorField(mentor);
            courseEntityDao.save(course);
            System.out.println("Mentor was added on course");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    /**
     * @param idAdmin
     */
    @Override
    public void takeCourseForControl(int idAdmin) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        adminEntityDao =
                DaoFactory.getInstance().getAdminDao();
        System.out.println("Введите id курса:");
        int idCourse = scanner.nextInt();
        if (courseEntityDao.findById(idCourse) != null
                && adminEntityDao.findById(idAdmin) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Admin admin = adminEntityDao.findById(idAdmin);
            course.setAdminField(admin);
            courseEntityDao.save(course);
            System.out.println("Admin was added on course");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();

    }

    @Override
    public void updateMentorToCourse(int idCourse, int idMentor) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        mentorEntityDao =
                DaoFactory.getInstance().getMentorDao();
        if (courseEntityDao.findById(idCourse) != null
                && mentorEntityDao.findById(idMentor) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Mentor mentor = mentorEntityDao.findById(idMentor);
            course.setMentorField(mentor);
            courseEntityDao.update(course);
            System.out.println("Update mentor.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    @Override
    public void updateAdminToCourse(int idCourse, int idAdmin) {
        courseEntityDao =
                DaoFactory.getInstance().getCourseDao();
        adminEntityDao =
                DaoFactory.getInstance().getAdminDao();
        if (courseEntityDao.findById(idCourse) != null
                && adminEntityDao.findById(idAdmin) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Admin admin = adminEntityDao.findById(idAdmin);
            course.setAdminField(admin);
            courseEntityDao.update(course);
            System.out.println("Update admin.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

}
