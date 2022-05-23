package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Mentor;

import java.util.Optional;

public interface MentorDao extends EntityDao<Mentor>{
    Optional<Mentor> findMentorById(Integer id);
    void clearMentorCourseList(Mentor mentorWithCourseList);
}
