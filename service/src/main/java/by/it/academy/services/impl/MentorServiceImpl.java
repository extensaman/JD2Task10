package by.it.academy.services.impl;

import by.it.academy.repository.dao.AdminDao;
import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.MentorDao;
import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.entity.Task;
import by.it.academy.services.MentorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MentorServiceImpl implements MentorService {
    private static final Logger LOGGER = LogManager.getLogger(MentorServiceImpl.class);
    public static final int SINGLE_ADMIN_INDEX = 0;
    private TaskDao taskDao;
    private AdminDao adminDao;
    private CourseDao courseDao;
    private AssessmentDao assessmentDao;

    public void createTask(int courseId, Task task)
            throws SecurityException {
        courseDao = DaoProvider.getInstance().getCourseDao();
        taskDao = DaoProvider.getInstance().getTaskDao();

        Course course = courseDao.findById(courseId);
        if (course == null) {
            System.out.println("Не найден курс с данным ID: " + courseId);
            return;
        }
        taskDao.save(task);
        task.setCourseField(course);
        taskDao.update(task);

        courseDao.closeDao();
        taskDao.closeDao();
    }

    public void deleteTask(int taskId)
            throws SecurityException {
        taskDao = DaoProvider.getInstance().getTaskDao();

        if (taskDao.findById(taskId) == null) {
            System.out.println("Не найдено задание с данным ID: " + taskId);
            return;
        }
        taskDao.delete(taskId);
        taskDao.closeDao();
    }

    public void createAssessment(int taskId, Assessment assessment)
            throws SecurityException {
        taskDao = DaoProvider.getInstance().getTaskDao();
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        Task task = taskDao.findById(taskId);
        if (task == null) {
            System.out.println("Не найдено задание с данным ID: " + taskId);
            return;
        }
        assessment.setTaskInAssessment(task);
        assessmentDao.save(assessment);

        taskDao.closeDao();
        assessmentDao.closeDao();
    }

    public void updateAssessment(Assessment assessment)
            throws SecurityException {
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        if (assessmentDao.findById(assessment.getId()) == null) {
            System.out.println("Не найден отзыв с данным ID: " + assessment.getId());
            return;
        }
        assessmentDao.update(assessment);

        assessmentDao.closeDao();
    }

    @Override
    public List<Mentor> findAllMentor() {
        List<Mentor> mentors = null;
        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();
        mentors = mentorDao.findAll();
        mentorDao.closeDao();
        return mentors;
    }

    @Override
    public void deleteById(Integer id) {
        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();
        mentorDao.delete(id);
        mentorDao.closeDao();
    }

    @Override
    public void save(String name, String[] courses_array, String[] admins_array) {
        // TODO Need add validation functionality
        adminDao = DaoProvider.getInstance().getAdminDao();
        courseDao = DaoProvider.getInstance().getCourseDao();

        Mentor newMentor = Mentor.builder().build();
        Optional.ofNullable(name)
                .ifPresent(newMentor::setMentorName);
        Optional.ofNullable(admins_array)
                .ifPresent(a ->
                        newMentor.setAdminMentorField(
                                adminDao.findAdminById(Integer.parseInt(a[SINGLE_ADMIN_INDEX]))
                                        .orElse(null)
                        )
                );
        Optional.ofNullable(courses_array)
                .ifPresent(courses -> {
                    newMentor.setCourses(
                            Stream.of(courses)
                                    .map(Integer::parseInt)
                                    .map(courseDao::findCourseById)
                                    .filter(Optional::isPresent)
                                    .map(Optional::get)
                                    .peek(LOGGER::trace)
                                    .peek(course -> course.setMentorField(newMentor))
                                    .peek(course -> courseDao.update(course))
                                    .collect(Collectors.toList())
                    );
                });

        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();
        mentorDao.save(newMentor);
        mentorDao.closeDao();

/*        Optional.ofNullable(courses_array)
                .ifPresent(courses ->
                            Stream.of(courses)
                                    .map(Integer::parseInt)
                                    .map(courseDao::findCourseById)
                                    .filter(Optional::isPresent)
                                    .map(Optional::get)
                                    .peek(LOGGER::trace)
                                    .forEach(course -> course.setMentorField(newMentor))
                );*/
    }
}
