package by.it.academy.controller;

import by.it.academy.controller.command.impl.AdminCommand;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminMentorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminMentorServlet",
        urlPatterns = {"/adminMentor"})
public class AdminMentorServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
    private static final String ADMIN_MENTOR = "adminMentor";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    public AdminMentorServlet() {
        super();
    }

    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        Integer mentorId = Integer.valueOf(request.getParameter("mentorId"));
        List<AdminMentorDto> allMentorFromAdmin = adminService.allMentorFromAdmin(mentorId);
        for (AdminMentorDto a : allMentorFromAdmin) {
            System.out.println(a.toString());
        }
        request.getSession().setAttribute(ADMIN_MENTOR, allMentorFromAdmin);
        LOGGER.trace(getClass().getSimpleName());
        request.getRequestDispatcher("WEB-INF/view/pages/adminMentor.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter("");

    }
}
