package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends EntityDao<Admin> {

    List<Course> showAllCourseAdmin(Integer adminId);

    List<Mentor> showAllMentorAdmin(Integer mentorId);

    Optional<Admin> findAdminById(Integer id);
}
