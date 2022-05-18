package by.it.academy.controller.addon;

import by.it.academy.controller.Controller;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "task", value = "/task")
public class Task extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    public static final String ASSESSMENT = "assessments";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer taskId = Integer.valueOf(request.getParameter("taskId"));
        List<AssessmentTdo> allAssessment = taskService.getListOfTaskAssessment(taskId);
        request.getSession().setAttribute(ASSESSMENT,allAssessment);
        logger.trace(getClass().getSimpleName());
        request.getRequestDispatcher("WEB-INF/view/pages/assessment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
