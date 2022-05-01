package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Task;

import java.util.List;

public interface AssessmentDao extends EntityDao<Assessment> {

    List<Assessment> getListOfTaskAssessment(Integer taskId);
    List<Assessment> getListOfStudentAssessment(Integer studentId);

}
