package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.StudentDao;
import by.it.academy.repository.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDaoImpl extends EntityDaoImpl<Student> implements StudentDao {
    public StudentDaoImpl(EntityManager em) {
        super(em, Student.class);
    }

    @Override
    public List getStudentAcademicPerformanceList(final Integer markLowBound, final Integer markHighBound) {
        Query query = entityManager.createQuery(
                "select s from Student as s, IN (s.assessments) as a where a.mark between :low and :high");
        query.setParameter("low", markLowBound);
        query.setParameter("high", markHighBound);
        return query.getResultList();

    }

    @Override
    public List getCourseListOfStudent(final Student student) {
        Query query = entityManager
                .createQuery("select c from Student s, " +
                        "IN(s.assessments) a, " +
                        "a.taskInAssessment t, " +
                        "t.courseField c " +
                        "where s.id = :studentId");
        query.setParameter("studentId", student.getId());
        return query.getResultList();
    }
}
