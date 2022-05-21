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
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/pages/newStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        studentService.createStudent(name);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>Student</title></head>");
        printWriter.println("<body><h1>Student created!</h1>");
        printWriter.println("</body></html>");
    }
}
