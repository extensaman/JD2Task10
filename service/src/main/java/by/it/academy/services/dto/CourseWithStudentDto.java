package by.it.academy.services.dto;

import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Student;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CourseWithStudentDto {
    private Integer id;
    private String courseProgram;
    private Integer studentId;

    public CourseWithStudentDto(Course course, Integer studentId) {
        this.id = course.getId();
        this.courseProgram = course.getCourseProgram();
        List<Integer> studentsIds = course.getStudents().stream()
                .map(Student::getId)
                .collect(Collectors.toList());
        if(studentsIds.contains(studentId)){
            this.studentId = studentId;
        }
    }
}
