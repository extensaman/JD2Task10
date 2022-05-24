package by.it.academy.controller.addon;

import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.StudentDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "newAssessment", value = "/newAssessment")
public class NewAssessment extends HttpServlet {
    public static final String TASK_ID = "taskId";
    public static final String WEB_INF_VIEW_PAGES_NEW_ASSESSMENT_JSP = "WEB-INF/view/pages/newAssessment.jsp";
    public static final String MARK = "mark";
    public static final String FEEDBACK = "feedback";
    public static final String HTML_HEAD_TITLE_FIRST_TITLE_HEAD = "<html><head><title>First</title></head>";
    public static final String BODY_H_1_TASK_CREATED_H_1 = "<body><h1>Task created!</h1>";
    public static final String BODY_HTML = "</body></html>";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    public static final String STUDENT = "students";
    private Integer taskId;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        taskId = Integer.valueOf(request.getParameter(TASK_ID));
        List<StudentDto> studentDtos = studentService.findAllStudentDto();
        request.getSession().setAttribute(STUDENT, studentDtos);
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_NEW_ASSESSMENT_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter(Constant.STUDENT_ID));
        Integer mark = Integer.valueOf(request.getParameter(MARK));
        String feedback = request.getParameter(FEEDBACK);
        taskService.createAssessment(taskId, studentId, mark, feedback);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(HTML_HEAD_TITLE_FIRST_TITLE_HEAD);
        printWriter.println(BODY_H_1_TASK_CREATED_H_1);
        printWriter.println(BODY_HTML);
    }
}
