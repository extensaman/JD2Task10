package by.it.academy.controller.servlets;

import by.it.academy.controller.command.Constant;
import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.CourseWithStudentDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "studentCourses", value = "/studentCourses")
public class StudentCourses extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    public static final String WEB_INF_VIEW_PAGES_STUDENT_COURSES_JSP = "WEB-INF/view/pages/studentCourses.jsp";
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();
    public static final String COURSES = "courses";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter(Constant.STUDENT_ID));

        List<CourseWithStudentDto> courses = courseService.findAllCourse().stream()
                .map((obj) -> new CourseWithStudentDto(obj, studentId))
                .collect(Collectors.toList());

        request.getSession().setAttribute(COURSES, courses);
        request.getSession().setAttribute(Constant.STUDENT_ID, studentId);
        logger.trace(getClass().getSimpleName());

        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_STUDENT_COURSES_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
