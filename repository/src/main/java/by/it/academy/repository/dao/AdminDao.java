package by.it.academy.repository.dao;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;

import java.util.List;

public interface AdminDao extends EntityDao<Admin> {

    List<Course> showAllCourseAdmin(Integer adminId);

}
