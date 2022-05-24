package by.it.academy.controller.servlets;

import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "newAdmin", value = "/newAdmin")
public class NewAdmin extends HttpServlet {

    public static final String WEB_INF_VIEW_PAGES_NEW_ADMIN_JSP = "WEB-INF/view/pages/newAdmin.jsp";
    public static final String NAME_ADMIN = "nameAdmin";
    public static final String HOME_PAGE_NAME_ADMIN = "/home?pageName=admin";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_NEW_ADMIN_JSP)
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameAdmin = request.getParameter(NAME_ADMIN);
        if (nameAdmin != null) {
            adminService.createAdmin(nameAdmin);
            System.out.println(nameAdmin);
            request.getRequestDispatcher(HOME_PAGE_NAME_ADMIN).forward(request, response);
        }
    }
}