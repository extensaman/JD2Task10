package by.it.academy;



import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.AdminServiceImpl;

import java.util.List;
import java.util.stream.Collectors;


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

//        EntityDao<Mentor> mentorDao = DaoFactory.getInstance().getMentorDao();
//        Mentor mentor01 = mentorDao.findById(1);
//
//        // Поставим студенту Student01 оценку 10
//        // за задание с описанием "TaskDescription01"
//
//        // Для этого сначала получим List оценок этого студента за это задание
//        List<Assessment> collect = mentor01.getCourses().stream()
//                .flatMap(course -> course.getStudents().stream())
//                .filter(student -> student.getStudentName().equals("Student01"))
//                .flatMap(student -> student.getAssessments().stream())
//                .filter(assessment -> assessment
//                        .getTaskInAssessment()
//                        .getDescription()
//                        .equals("TaskDescription01"))
//                .collect(Collectors.toList());
//        mentorDao.closeDao();
//
//        // Затем простаим оценку
//        collect.forEach(assessment -> {
//            assessment.setMark(10);
//            assessment.setFeedback("Brilliant");
//        });
//
//        // Затем заливаем ее в БД
//        EntityDao<Assessment> assessmentEntityDao =
//                DaoFactory.getInstance().getAssessmentDao();
//        collect.forEach(assessmentEntityDao::update);
//        assessmentEntityDao.closeDao();
//
//        // Проверяем, что у нас получилось, но уже через Курсы "заходим"
//        EntityDao<Course> courseDao =
//                DaoFactory.getInstance().getCourseDao();
//        Course course01 = courseDao.findById(1);
//        System.out.println(course01.getStudents()
//                .get(0) // This is "Student01"
//                .getAssessments()
//                .get(0)  // This assessment with "TaskDescription01"
//                .getMark());
//        courseDao.closeDao();
//    }


        AdminServiceImpl a = new AdminServiceImpl();
        a.createCourse("AS");


    }
}

