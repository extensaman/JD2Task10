package by.it.academy.controller.addon;

import by.it.academy.controller.command.impl.AdminCommand;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.impl.AdminServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminCourseServlet",
        urlPatterns = {"/adminCourse"})
public class AdminCourseServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
    private static final String ADMIN_COURSE = "adminCourse";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    public AdminCourseServlet() {
        super();
    }

    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        Integer adminId = Integer.valueOf(request.getParameter("adminId"));
        List<AdminCourseDto> allCourseFromAdmin = adminService.allCourseFromAdmin(adminId);
        for (AdminCourseDto a : allCourseFromAdmin) {
            System.out.println(a.toString());
        }
        request.getSession().setAttribute(ADMIN_COURSE, allCourseFromAdmin);
        LOGGER.trace(getClass().getSimpleName());
        request.getRequestDispatcher("WEB-INF/view/pages/adminCourse.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    request.getParameter("");

    }
}
