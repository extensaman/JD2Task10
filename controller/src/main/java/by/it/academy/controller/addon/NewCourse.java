package by.it.academy.controller.addon;

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

    public static final String WEB_INF_VIEW_PAGES_NEW_COURSE_JSP = "WEB-INF/view/pages/newCourse.jsp";
    public static final String NAME_COURSE = "nameCourse";
    public static final String HOME_PAGE_NAME_COURSE = "/home?pageName=course";
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_NEW_COURSE_JSP)
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameCourse = request.getParameter(NAME_COURSE);
        if (nameCourse != null) {
            courseService.createCourse(nameCourse);
            System.out.println(nameCourse);
            request.getRequestDispatcher(HOME_PAGE_NAME_COURSE).forward(request, response);
        }
    }
}