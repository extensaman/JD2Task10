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
