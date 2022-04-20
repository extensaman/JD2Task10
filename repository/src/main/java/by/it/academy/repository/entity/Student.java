package by.it.academy.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/*@SuperBuilder*/
@Data
@AllArgsConstructor
@Entity
@Table
@DiscriminatorValue("Student")
public class Student extends Person{
}
