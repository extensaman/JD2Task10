package by.it.academy.services;


import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> findAllTaskDto();

    void createTask(String taskName, Integer courseId);

    void removeTask(Integer taskId);

    void updateTask(Integer taskId, String newName, Integer CourseId);

    void createAssessment(Integer taskId, Integer studentId, Integer mark, String feedback);
}
