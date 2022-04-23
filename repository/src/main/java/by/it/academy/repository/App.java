package by.it.academy.repository;

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

        // RELOCATED to SERVICE module
        // IT'S NECESSARY to DELETE this CLASS



        /*System.out.println("Start!");

        EntityDao<Mentor> mentorDao = DaoProductionFactory.getInstance().getMentorDao();
        EntityDao<Course> courseDao = DaoProductionFactory.getInstance().getCourseDao();

        Mentor mentor01 = mentorDao.findById(1);


        List<Course> courses = mentor01.getCourses();
        for (Course course : courses) {
            System.out.println(course.getCourseProgram());
        }

        List<Assessment> collect = mentor01.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getStudentName().equals("Student01"))
                .flatMap(student -> student.getAssessments().stream())
                .filter(assessment -> assessment
                        .getTaskInAssessment()
                        .getDescription()
                        .equals("TaskDescription01"))
                .collect(Collectors.toList());
        mentorDao.closeDao();
        collect.forEach(assessment -> {
            assessment.setMark(10);
            assessment.setFeedback("Brilliant");
        });
        EntityDao<Assessment> assessmentEntityDao = DaoProductionFactory.getInstance().getAssessmentDao();
        collect.forEach(assessmentEntityDao::update);
        assessmentEntityDao.closeDao();

        Course course01 = courseDao.findById(1);
        System.out.println(course01.getStudents().get(0).getAssessments().get(0).getMark());

        courseDao.closeDao();*/
    }
}
