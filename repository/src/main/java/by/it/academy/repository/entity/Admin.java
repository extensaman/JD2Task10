package by.it.academy.repository.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "admin_name", length = 50)
    private String adminName;

    @OneToMany(mappedBy = "adminField", fetch = FetchType.LAZY,orphanRemoval = false)
    private List<Course> courses;

    @OneToMany(mappedBy = "adminMentorField", fetch = FetchType.LAZY,orphanRemoval = false)
    private List<Mentor> mentors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return id != null && Objects.equals(id, admin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "adminName = " + adminName + ")";
    }
}
