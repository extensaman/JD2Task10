package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminDto;

import java.util.List;
import java.util.Optional;
import by.it.academy.services.dto.AdminMentorDto;

public interface AdminService {

    List<AdminDto> showAllAdminDto();

    List<AdminCourseDto> allCourseFromAdmin(Integer adminId);

    List<AdminMentorDto> allMentorFromAdmin(Integer mentorId);

    void createAdmin(String nameCourse) throws SecurityException;

    void deleteAdmin(Integer adminId);

    void createCourse(String nameCourse) throws SecurityException;

    void deleteMentorById(int idMentor) throws SecurityException;

    void deleteMentorByName() throws SecurityException;

    void createMentor(String nameMentor) throws SecurityException;

    void deleteCourseById(int idCourse) throws SecurityException;

    void deleteCourseByName() throws SecurityException;

    void insertMentorToCourse(int idCourse, int idMentor) throws SecurityException;

    void takeCourseForControl(int idAdmin) throws SecurityException;

    void updateMentorToCourse(int idCourse, int idMentor) throws SecurityException;

    void updateAdminToCourse(int idCourse, int idAdmin) throws SecurityException;

    List<Admin> findAllAdmin();

}
