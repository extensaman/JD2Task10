package by.it.academy.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

/*@SuperBuilder*/
@Data
@AllArgsConstructor
@Entity
@Table
public class Mentor extends Person implements Serializable {
    /*@ManyToOne(cascade = CascadeType.PERSIST)*/
    @JoinColumn(name = "COURSE_ID")
    private Course course;
}
