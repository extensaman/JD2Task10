package by.it.academy.services.impl;

import by.it.academy.repository.dao.AdminDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.MentorDao;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.AdminService;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.AdminForMentorDto;
import by.it.academy.services.dto.AdminMentorDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {
    private static final String CHECKED = "checked";
    private static final String NOT_CHECKED = "";

    @Override
    public List<AdminDto> showAllAdminDto() {
        List<AdminDto> result = null;
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        result = adminDao.findAll().stream()
                .map(AdminDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return result;
    }

    @Override
    public List<AdminCourseDto> allCourseFromAdmin(Integer adminId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        List<AdminCourseDto> courseFromAdmin = null;
        courseFromAdmin = adminDao.showAllCourseAdmin(adminId).stream()
                .map(AdminCourseDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return courseFromAdmin;
    }

    @Override
    public List<AdminMentorDto> allMentorFromAdmin(Integer mentorId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        List<AdminMentorDto> mentorFromAdmin = null;
        mentorFromAdmin = adminDao.showAllMentorAdmin(mentorId).stream()
                .map(AdminMentorDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return mentorFromAdmin;
    }

    @Override
    public void createAdmin(String nameCourse)
            throws SecurityException {
        EntityDao<Admin> adminEntityDao = DaoProvider.getInstance().getAdminDao();
        Admin newAdmin = Admin.builder()
                .adminName(nameCourse)
                .build();
        adminEntityDao.save(newAdmin);
        adminEntityDao.closeDao();
    }

    public void deleteAdmin(Integer adminId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        adminDao.delete(adminId);
        adminDao.closeDao();
    }

    @Override
    public void createCourse(String nameCourse)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        Course course = Course.builder()
                .courseProgram(nameCourse)
                .build();
        courseEntityDao.save(course);
        courseEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void createMentor(String nameMentor)
            throws SecurityException {
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        Mentor mentor = Mentor.builder()
                .mentorName(nameMentor)
                .build();
        mentorEntityDao.save(mentor);
        mentorEntityDao.closeDao();
    }

    @Override
    public List<Admin> findAllAdmin() {
        List<Admin> admins = null;
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        admins = adminDao.findAll();
        adminDao.closeDao();
        return admins;
    }

    @Override
    public List<AdminForMentorDto> findAllAdminForMentor() {
        List<AdminForMentorDto> admins = null;
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        admins = adminDao.findAll().stream()
                .map(admin -> AdminForMentorDto.builder()
                        .id(admin.getId())
                        .adminName(admin.getAdminName())
                        .checked(NOT_CHECKED)
                        .build())
                .collect(Collectors.toList());
        adminDao.closeDao();
        return admins;
    }

    @Override
    public List<AdminForMentorDto> findAllAdminForMentorWithCheckedExisting(Integer mentorId) {
        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();
        Integer existingAdminId = mentorDao.findMentorById(mentorId)
                .map(mentor ->
                        Optional.ofNullable(mentor.getAdminMentorField())
                                .map(Admin::getId)
                                .orElse(null))
                .orElse(null);
        List<AdminForMentorDto> allAdminForMentorWithCheckedExisting = findAllAdminForMentor();

        allAdminForMentorWithCheckedExisting.forEach(admin -> {
            if (admin.getId().equals(existingAdminId)) {
                admin.setChecked(CHECKED);
            }
        });

        return allAdminForMentorWithCheckedExisting;
    }
}
