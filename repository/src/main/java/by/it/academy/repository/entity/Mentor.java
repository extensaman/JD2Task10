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
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "mentor_name", length = 50)
    private String mentorName;

    @OneToMany(mappedBy = "mentorField", fetch = FetchType.LAZY)
    private List<Course> courses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_mentor_id")
    private Admin adminMentorField;
}
