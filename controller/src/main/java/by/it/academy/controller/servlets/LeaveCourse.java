package by.it.academy.controller.servlets;

import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "leaveCourse", value = "/leaveCourse")
public class LeaveCourse extends HttpServlet {
    public static final String STUDENT_COURSES_STUDENT_ID = "/studentCourses?studentId=";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter(Constant.STUDENT_ID));
        Integer courseId = Integer.valueOf(request.getParameter(Constant.COURSE_ID));
        studentService.leaveCourse(studentId, courseId);
        response.sendRedirect(request.getContextPath() + STUDENT_COURSES_STUDENT_ID + studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
