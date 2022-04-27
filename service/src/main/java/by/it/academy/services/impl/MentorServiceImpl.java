package by.it.academy.services.impl;

import by.it.academy.repository.dao.DaoFactory;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Task;
import by.it.academy.services.MentorService;

public class MentorServiceImpl implements MentorService {
    private static EntityDao<Task> taskDao;
    private static EntityDao<Course> courseDao;
    private static EntityDao<Assessment> assessmentDao;

    public void createTask(int courseId, Task task)
            throws SecurityException {
        courseDao = DaoFactory.getInstance().getCourseDao();
        taskDao = DaoFactory.getInstance().getTaskDao();

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
        taskDao = DaoFactory.getInstance().getTaskDao();

        if (taskDao.findById(taskId) == null) {
            System.out.println("Не найдено задание с данным ID: " + taskId);
            return;
        }
        taskDao.delete(taskId);
        taskDao.closeDao();
    }
    public void createAssessment(int taskId, Assessment assessment)
            throws SecurityException {
        taskDao = DaoFactory.getInstance().getTaskDao();
        assessmentDao = DaoFactory.getInstance().getAssessmentDao();

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
        assessmentDao = DaoFactory.getInstance().getAssessmentDao();

        if (assessmentDao.findById(assessment.getId()) == null) {
            System.out.println("Не найден отзыв с данным ID: " + assessment.getId());
            return;
        }
        assessmentDao.update(assessment);

        assessmentDao.closeDao();
    }
}
