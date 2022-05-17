package by.it.academy.services.dto;

import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AdminMentorDto {
    private Integer id;
    private String nameMentor;

    public AdminMentorDto(Mentor mentor) {
        this.id = mentor.getId();
        this.nameMentor = mentor.getMentorName();
    }
}

