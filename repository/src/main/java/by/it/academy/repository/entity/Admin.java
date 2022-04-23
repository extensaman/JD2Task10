package by.it.academy.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "admin_name", length = 50)
    private String adminName;
    @EqualsAndHashCode.Exclude
@ToString.Exclude
    @OneToMany(mappedBy = "adminField", fetch = FetchType.LAZY)
    private List<Course> courses;
@EqualsAndHashCode.Exclude
@ToString.Exclude
    @OneToMany(mappedBy = "adminMentorField", fetch = FetchType.LAZY)
    private List<Mentor> mentors;
}
