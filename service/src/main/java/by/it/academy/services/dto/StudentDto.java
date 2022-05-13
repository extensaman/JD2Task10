package by.it.academy.services.dto;


import by.it.academy.repository.entity.Student;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class StudentDto {
    private final Integer id;
    private final String studentName;
    private final Integer assessmentCount;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.assessmentCount = student.getAssessments().size();
    }
}
