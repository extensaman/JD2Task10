package by.it.academy.services.dto;

import by.it.academy.repository.entity.Course;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CourseDto {
    private final Integer id;
    private String name;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getCourseProgram();
    }
}
