package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Task;

import java.util.List;

public interface TaskDao extends EntityDao<Task> {

    List<Task> getListOfCourseTasks(String courseName);

    List<Task> getListOfStudentTasks(String studentName);


}
