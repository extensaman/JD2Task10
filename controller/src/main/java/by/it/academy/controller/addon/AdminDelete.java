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
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer idAdminForDelete = Integer.valueOf(request.getParameter("idAdmin"));
            adminService.deleteAdmin(idAdminForDelete);
            response.sendRedirect(request.getContextPath() + "/home?pageName=admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
