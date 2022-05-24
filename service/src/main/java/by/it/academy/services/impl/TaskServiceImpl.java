package by.it.academy.services.impl;

import by.it.academy.repository.dao.*;
import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import by.it.academy.repository.entity.Task;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDto> findAllTaskDto() {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        List<TaskDto> result;
        result = taskDao.findAll()
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        taskDao.closeDao();
        return result;
    }

    @Override
    public void createTask(String taskName, Integer courseId) {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        Course course = courseDao.findById(courseId);
        courseDao.closeDao();
        Task task = Task.builder()
                .description(taskName)
                .courseField(course).build();
        taskDao.save(task);
        taskDao.closeDao();
    }

    public void removeTask(Integer taskId) {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        taskDao.delete(taskId);
        taskDao.closeDao();
    }

    @Override
    public void updateTask(Integer taskId, String newName, Integer courseId) {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        Course course = courseDao.findById(courseId);
        Task task = taskDao.findById(taskId);
        task.setDescription(newName);
        task.setCourseField(course);
        taskDao.update(task);
        taskDao.closeDao();
        courseDao.closeDao();
    }

    @Override
    public void createAssessment(Integer taskId, Integer studentId, Integer mark, String feedback) {
        AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        StudentDao studentDao = DaoProvider.getInstance().getStudentDao();
        Task task = taskDao.findById(taskId);
        Student student = studentDao.findById(studentId);
        Assessment assessment = Assessment.builder()
                .taskInAssessment(task)
                .studentInAssessment(student)
                .mark(mark)
                .feedback(feedback).build();
        assessmentDao.save(assessment);
        studentDao.closeDao();
        taskDao.closeDao();
        assessmentDao.closeDao();
    }
}
