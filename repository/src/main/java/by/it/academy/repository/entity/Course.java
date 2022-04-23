package by.it.academy.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "course_program", length = 1000)
    private String courseProgram;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor_id")
    private Mentor mentorField;

    @OneToMany(mappedBy = "courseField", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin adminField;
}
