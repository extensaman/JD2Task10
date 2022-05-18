package by.it.academy.controller.addon;

import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.CourseDto;
import by.it.academy.services.dto.StudentDto;
import by.it.academy.services.dto.TaskDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "newAssessment", value = "/newAssessment")
public class NewAssessment extends HttpServlet {
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    public static final String STUDENT = "students";
    private Integer taskId;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        taskId = Integer.valueOf(request.getParameter("taskId"));
        List<StudentDto> studentDtos = studentService.findAllStudentDto();
        request.getSession().setAttribute(STUDENT,studentDtos);
        request.getRequestDispatcher("WEB-INF/view/pages/newAssessment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter("studentId"));
        Integer mark = Integer.valueOf(request.getParameter("mark"));
        String feedback = request.getParameter("feedback");
        taskService.createAssessment(taskId,studentId,mark,feedback);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>First</title></head>");
        printWriter.println("<body><h1>Task created!</h1>");
        printWriter.println("</body></html>");
    }
}
