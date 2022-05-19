package by.it.academy.controller.addon;

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
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter("studentId"));
        studentService.deleteStudent(studentId);
        response.sendRedirect(request.getContextPath() + "/home?pageName=student");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

