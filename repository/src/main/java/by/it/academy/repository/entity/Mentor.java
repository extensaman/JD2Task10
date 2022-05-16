package by.it.academy.repository.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "mentor_name", length = 50)
    private String mentorName;

    @OneToMany(mappedBy = "mentorField", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Course> courses;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_mentor_id")
    private Admin adminMentorField;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mentor mentor = (Mentor) o;
        return id != null && Objects.equals(id, mentor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "mentorName = " + mentorName + ", " +
                "adminMentorField = " + adminMentorField + ")";
    }
}
