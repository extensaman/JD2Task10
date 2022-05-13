package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.StudentDto;

import java.util.List;

public interface AdminService {

    List<AdminDto> showAllAdminDto();


    void createCourse(String nameCourse) throws SecurityException;
  void deleteMentorById(int idMentor) throws SecurityException;
    void deleteMentorByName() throws SecurityException;
  void createMentor(String nameMentor) throws SecurityException;
    void deleteCourseById(int idCourse) throws SecurityException;
    void deleteCourseByName() throws SecurityException;
    void insertMentorToCourse(int idCourse,int idMentor) throws SecurityException;
    void takeCourseForControl(int idAdmin) throws SecurityException;
    void updateMentorToCourse(int idCourse, int idMentor) throws SecurityException;
    void updateAdminToCourse(int idCourse, int idAdmin) throws SecurityException;
}
