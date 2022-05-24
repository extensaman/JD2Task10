package by.it.academy.controller.addon;

import by.it.academy.controller.command.Constant;
import by.it.academy.controller.command.impl.AdminCommand;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminCourseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCourseServlet",
        urlPatterns = {"/adminCourse"})
public class AdminCourseServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AdminCourseServlet.class);
    private static final String ADMIN_COURSE = "adminCourse";
    public static final String WEB_INF_VIEW_PAGES_ADMIN_COURSE_JSP = "WEB-INF/view/pages/adminCourse.jsp";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    public AdminCourseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        Integer adminId = Integer.valueOf(request.getParameter(Constant.ADMIN_ID));
        List<AdminCourseDto> allCourseFromAdmin = adminService.allCourseFromAdmin(adminId);
        request.getSession().setAttribute(ADMIN_COURSE, allCourseFromAdmin);
        LOGGER.trace(getClass().getSimpleName());
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_ADMIN_COURSE_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


    }
}
