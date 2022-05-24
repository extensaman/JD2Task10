package by.it.academy.controller.addon;

import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminDelete", value = "/adminDelete")
public class AdminDelete extends HttpServlet {
    public static final String ID_ADMIN = "idAdmin";
    public static final String HOME_PAGE_NAME_ADMIN = "/home?pageName=admin";
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer idAdminForDelete = Integer.valueOf(request.getParameter(ID_ADMIN));
            adminService.deleteAdmin(idAdminForDelete);
            response.sendRedirect(request.getContextPath() + HOME_PAGE_NAME_ADMIN);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
