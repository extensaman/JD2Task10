package by.it.academy.repository.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "taskInAssessment")
@EqualsAndHashCode
@Entity
@Table(name = "assessment")
public class Assessment {

    @Id
    @GenericGenerator(name = "one-one",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "taskInAssessment"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "task_id")
    private Integer id;

    @Column
    private Integer mark;

    @Column(length = 1000)
    private String feedback;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student studentInAssessment;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Task taskInAssessment;
}
