package by.it.academy.services.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Task;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
    private AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();

    @Override
    public List<TaskDto> taskDtos() {
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
    }
}
