package by.it.academy.controller.command.impl.mentor;

import by.it.academy.controller.command.Command;
import by.it.academy.services.AdminService;
import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MentorUpdateToDbCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorUpdateToDbCommand.class);
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    }
}
