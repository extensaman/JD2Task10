package by.it.academy.services.dto;

import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Task;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class TaskDto {
    private final Integer id;
    private String name;
    private String curse;

    private List<AssessmentTdo> assessments = new ArrayList<>();

    public TaskDto(Task task) {
        System.out.println(task);
        this.id = task.getTaskId();
        this.name = task.getDescription();
        this.curse = task.getCourseField().getCourseProgram();
    }
}
