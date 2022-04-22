package by.it.academy.repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", unique = true)
    private Integer taskId;

    @Column(length = 1000)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseField;

    @OneToOne(mappedBy = "taskInAssessment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Assessment assessment;
}
