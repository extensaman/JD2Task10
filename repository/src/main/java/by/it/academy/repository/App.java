package by.it.academy.repository;

import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.impl.EntityDaoImpl;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Create a project.
 * It has two maven submodules, the first is "repository",
 * the second is "service". Connect checkstyle, jacoco.
 * <p>
 * In maven submodule "repository" implement mapping on JPA entity(Hibernate),
 * create DAO using class parameterization via Generic.
 * Create a database using liquibase.
 * Cover with tests using H2 (write the database through Hibernate).
 * <p>
 * In the maven submodule "service" implement the connection of the maven submodule "repository".
 * Implement a class containing the main() method.
 * In the main() method, fill the database with test data via DAO.
 * <p>
 * There is a list of Courses, each of which is assigned to the Mentor.
 * The Student studies at one or more Courses, performs tasks.
 * The Mentor assigns grades for tasks to the Student and adds feedback.
 * The Administrator manages Courses and Mentors. (Add fields for entities as needed of your choice)
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Start!");

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("production");

        EntityDao<Mentor> mentorDao = new EntityDaoImpl<>(factory, Mentor.class);
        EntityDao<Course> courseDao = new EntityDaoImpl<>(factory, Course.class);

        Mentor mentor01 = mentorDao.findById(1);
        Course course02 = courseDao.findById(2);

        System.out.println("-=-= There are courses of Mentor01:");
        mentor01.getCourses().stream()
                .map(Course::getCourseProgram)
                .forEach(System.out::println);

        System.out.println("-=-= This is the mentor of Course02:");
        System.out.println(course02.getMentorField().getMentorName());


        System.out.println("-=-= Set Mentor01 to mentoring of Course02...");
        course02.setMentorField(mentor01);


        System.out.println("-=-= Update Course02");
        courseDao.update(course02);
        System.out.println("-=-= Make findById Course02");
        course02 = courseDao.findById(2);
        System.out.println("-=-= This is the mentor of Course02:");
        System.out.println(course02.getMentorField().getMentorName());

        System.out.println("-=-= There are courses of Mentor01:");
        mentor01 = mentorDao.findById(1);
        mentor01.getCourses().stream()
                .map(Course::getCourseProgram)
                .forEach(System.out::println);

        factory.close();
    }
}
