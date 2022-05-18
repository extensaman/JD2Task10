package by.it.academy.services;

import by.it.academy.services.impl.AdminServiceImpl;
import by.it.academy.services.impl.CourseServiceImpl;
import by.it.academy.services.impl.MentorServiceImpl;
import by.it.academy.services.impl.StudentServiceImpl;
import by.it.academy.services.impl.TaskServiceImpl;

public class ServiceProvider {

    private final AdminService adminService = new AdminServiceImpl();
    private final MentorService mentorService = new MentorServiceImpl();
    private final CourseService courseService = new CourseServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    private final TaskService taskService = new TaskServiceImpl();

    private final static ServiceProvider INSTANCE = new ServiceProvider();

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public MentorService getMentorService() {
        return mentorService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public TaskService taskService() {
        return taskService;
    }
}
