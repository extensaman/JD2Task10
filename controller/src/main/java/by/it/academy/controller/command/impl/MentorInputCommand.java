package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.repository.entity.Course;
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
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Course> allCourse = courseService.findAllCourse();
        LOGGER.trace(getClass().getSimpleName() + " --- allCourse = " + allCourse);
        req.getSession().setAttribute(COURSES, allCourse);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
