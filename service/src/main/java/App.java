import by.it.academy.repository.entity.Person;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.util.HibernateUtil;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        Person person = Person.builder().name("Студент").surname("Студентович").build();
        Course course = Course.builder().name("java").grade(5).build();
        /*course.getMentor().add(person);*/
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        HibernateUtil.close();

    }
}

