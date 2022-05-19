package by.it.academy.controller;

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

    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/pages/newAdmin.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameAdmin = request.getParameter("nameAdmin");
        if (nameAdmin != null) {
            adminService.createAdmin(nameAdmin);
            System.out.println(nameAdmin);
            request.getRequestDispatcher("/home?pageName=admin").forward(request, response);
        } else {
            //  request.getRequestDispatcher("success.jsp").forward(request, response);
        }
    }
}