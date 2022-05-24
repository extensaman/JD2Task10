package by.it.academy.controller.addon;

import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "newStudent", value = "/newStudent")
public class NewStudent extends HttpServlet {
    public static final String WEB_INF_VIEW_PAGES_NEW_STUDENT_JSP = "WEB-INF/view/pages/newStudent.jsp";
    public static final String NAME = "Name";
    public static final String HTML_HEAD_TITLE_STUDENT_TITLE_HEAD = "<html><head><title>Student</title></head>";
    public static final String BODY_H_1_STUDENT_CREATED_H_1 = "<body><h1>Student created!</h1>";
    public static final String BODY_HTML = "</body></html>";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_NEW_STUDENT_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(NAME);
        studentService.createStudent(name);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(HTML_HEAD_TITLE_STUDENT_TITLE_HEAD);
        printWriter.println(BODY_H_1_STUDENT_CREATED_H_1);
        printWriter.println(BODY_HTML);
    }
}
