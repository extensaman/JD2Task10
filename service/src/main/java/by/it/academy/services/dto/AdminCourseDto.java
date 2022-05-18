package by.it.academy.services.dto;

import by.it.academy.repository.entity.Course;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AdminCourseDto {
    private Integer id;
    private String nameCourse;

    public AdminCourseDto(Course course) {
        this.id = course.getId();
        this.nameCourse = course.getCourseProgram();
    }
}
