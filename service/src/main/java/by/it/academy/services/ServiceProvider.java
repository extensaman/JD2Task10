package by.it.academy.services;

import by.it.academy.services.impl.AdminServiceImpl;
import by.it.academy.services.impl.MentorServiceImpl;
import by.it.academy.services.impl.StudentServiceImpl;

public class ServiceProvider {

    private final AdminService adminService = new AdminServiceImpl();
    private final MentorService mentorService = new MentorServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();

    private static class SingletonHolder {
        private final static ServiceProvider INSTANCE = new ServiceProvider();
    }

    public static ServiceProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public MentorService getMentorService() {
        return mentorService;
    }

    public StudentService getStudentService() {
        return studentService;
    }
}
