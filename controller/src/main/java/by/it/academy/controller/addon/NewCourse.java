package by.it.academy.controller.addon;

import by.it.academy.services.AdminService;
import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "newCourse", value = "/newCourse")
public class NewCourse extends HttpServlet {

    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/pages/newCourse.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameCourse = request.getParameter("nameCourse");
        if (nameCourse != null) {
            courseService.createCourse(nameCourse);
            System.out.println(nameCourse);
            request.getRequestDispatcher("/home?pageName=course").forward(request, response);
        } else {
            //  request.getRequestDispatcher("success.jsp").forward(request, response);
        }
    }
}