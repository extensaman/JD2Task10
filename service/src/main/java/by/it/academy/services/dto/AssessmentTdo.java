package by.it.academy.services.dto;

import by.it.academy.repository.entity.Assessment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class AssessmentTdo {
    private final Integer id;
    private String name;
    private String studentName;
    private Integer mark;
    private String feedback;

    public AssessmentTdo(Assessment assessment) {
        this.id = assessment.getId();
        this.name = assessment.getFeedback();
        this.studentName = assessment.getStudentInAssessment().getStudentName();
        this.mark = assessment.getMark();
        this.feedback = assessment.getFeedback();
    }
}
