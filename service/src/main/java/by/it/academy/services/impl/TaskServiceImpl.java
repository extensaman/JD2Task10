package by.it.academy.services.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Course;
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
        List<TaskDto> result = null;
        result = taskDao.findAll()
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        taskDao.closeDao();

        result.forEach(taskDto -> taskDto.setAssessments(extracted(taskDto.getId())));

        return result;
    }

    private List<AssessmentTdo> extracted(Integer taskId) {
        return assessmentDao.getListOfTaskAssessment(taskId)
                .stream().map(AssessmentTdo::new).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new TaskServiceImpl().taskDtos());
        System.out.println(new TaskServiceImpl().extracted(3));

        return result;
    }

    @Override
    public List<AssessmentTdo> getListOfTaskAssessment(Integer taskId) {
        AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();
        List<AssessmentTdo> result = null;
        result = assessmentDao.getListOfTaskAssessment(taskId)
                .stream().map(AssessmentTdo::new).collect(Collectors.toList());
        assessmentDao.closeDao();
        return result;
    }
    @Override
    public void createTask(String taskName,Integer courseId){
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        Course course = courseDao.findById(courseId);
        courseDao.closeDao();
        Task task = Task.builder()
                .description(taskName)
                .courseField(course).build();
        System.out.println(task);
        taskDao.save(task);
        taskDao.closeDao();
    }

    public static void main(String[] args) {
        new TaskServiceImpl().createTask("kksdkfs",1);
       /*System.out.println(new TaskServiceImpl().findAllTaskDto());*/
        /* System.out.println(new TaskServiceImpl().getListOfTaskAssessment(3));*/
    }
}
