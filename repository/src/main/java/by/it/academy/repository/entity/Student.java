package by.it.academy.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "student_name", length = 50)
    private String studentName;

    @OneToMany(mappedBy = "studentInAssessment", fetch = FetchType.LAZY)
    private List<Assessment> assessments;
}
