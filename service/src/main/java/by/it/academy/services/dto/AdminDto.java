package by.it.academy.services.dto;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AdminDto {

    private Integer id;
    private String adminName;
    private Integer adminAddedToCourse;
    private Integer adminAddedToMentors;

    public AdminDto(Admin admin) {
        this.id = admin.getId();
        this.adminName = admin.getAdminName();
        this.adminAddedToCourse = admin.getCourses().size();
        this.adminAddedToMentors = admin.getMentors().size();
    }
}
