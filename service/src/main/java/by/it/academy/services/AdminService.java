package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.AdminForMentorDto;
import by.it.academy.services.dto.AdminMentorDto;

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

    void createMentor(String nameMentor) throws SecurityException;

    List<Admin> findAllAdmin();

    List<AdminForMentorDto> findAllAdminForMentorWithCheckedExisting(Integer mentorId);

    List<AdminForMentorDto> findAllAdminForMentor();
}
