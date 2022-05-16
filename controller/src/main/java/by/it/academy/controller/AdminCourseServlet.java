package by.it.academy.controller;

import by.it.academy.services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminCourseServlet",
        urlPatterns = {"/AdminCourseServlet"})
public class AdminCourseServlet extends HttpServlet {

    public AdminCourseServlet() {
        super();
    }

    public void init() throws ServletException {

    }
/*
 private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
    public static final String ADMIN_COURSE = "adminCourse";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();


    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(getClass().getSimpleName());
        Integer adminId = Integer.valueOf(req.getParameter("adminId"));
        List<AdminCourseDto> allCourseFromAdmin = adminService.allCourseFromAdmin(adminId);
        req.getSession().setAttribute(ADMIN, allCourseFromAdmin);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
 */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String s = "This is " + this.getClass().getName()
                + " using the Get method";
        response.getWriter().print(s);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String s = "This is" + this.getClass().getName()
                + "using the Post method";
        response.getWriter().print(s);
    }

    public void destroy() {
        super.destroy();
    }
}
