package by.it.academy.controller.addon;

import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteStudent", value = "/deleteStudent")
public class DeleteStudent extends HttpServlet {
    public static final String HOME_PAGE_NAME_STUDENT = "/home?pageName=student";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter(Constant.STUDENT_ID));
        studentService.deleteStudent(studentId);
        response.sendRedirect(request.getContextPath() + HOME_PAGE_NAME_STUDENT);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

