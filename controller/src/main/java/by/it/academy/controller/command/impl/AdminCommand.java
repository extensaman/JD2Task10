package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
    public static final String ADMIN = "admin";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(getClass().getSimpleName());

        List<AdminDto> allAdmin = adminService.showAllAdminDto();
        req.getSession().setAttribute(ADMIN, allAdmin);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);



    }
}
