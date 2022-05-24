package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.dto.AssessmentTdo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AssessmentCommand implements Command {
    public static final String TASK_ID = "taskId";
    public static final String ASSESSMENT = "assessments";
    public static final String TASK_NAME = "taskName";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String taskName = req.getParameter(TASK_NAME);
        Integer taskId = Integer.valueOf(req.getParameter(TASK_ID));

        List<AssessmentTdo> allAssessment = studentService.getListOfStudentAssessment(taskId);
        req.getSession().setAttribute(ASSESSMENT, allAssessment);
        req.getSession().setAttribute(TASK_NAME, taskName);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
