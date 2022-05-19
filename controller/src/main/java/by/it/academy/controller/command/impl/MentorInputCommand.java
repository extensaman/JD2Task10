package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.services.AdminService;
import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MentorInputCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorInputCommand.class);
    public static final String COURSES = "courses";
    public static final String ADMINS = "admins";
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Course> allCourseWithoutMentor = courseService.findAllCourseWithoutMentor();
        List<Admin> allAdmin = adminService.findAllAdmin();
        LOGGER.trace(getClass().getSimpleName() + " --- allCourseWithoutMentor = " + allCourseWithoutMentor);
        LOGGER.trace(getClass().getSimpleName() + " --- allAdmin = " + allAdmin);
        req.getSession().setAttribute(COURSES, allCourseWithoutMentor);
        req.getSession().setAttribute(ADMINS, allAdmin);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}