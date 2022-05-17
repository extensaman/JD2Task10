package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminCourseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.controller.command.impl.AdminCommand.ADMIN;


public class AdminCourseCommand {

    private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
    public static final String ADMIN_COURSE = "adminCourse";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();


    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(getClass().getSimpleName());
        Integer adminId = Integer.valueOf(req.getParameter("adminId"));
        List<AdminCourseDto> allCourseFromAdmin = adminService.allCourseFromAdmin(adminId);
        req.getSession().setAttribute(ADMIN, allCourseFromAdmin);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);


    }
}
