package by.it.academy.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
/*@Inheritance(strategy = InheritanceType.JOINED)*/
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Integer id;
    @Column
    private String name;
   /* @OneToMany(mappedBy = "Course")*/
    @Column
    private Mentor mentor;
    @Column
    private Integer grade;
}
