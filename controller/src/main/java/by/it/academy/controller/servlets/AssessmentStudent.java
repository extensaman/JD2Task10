package by.it.academy.controller.servlets;

import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.dto.AssessmentTdo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "assessment", value = "/assessment")
public class AssessmentStudent extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AssessmentStudent.class);
    public static final String WEB_INF_VIEW_PAGES_ASSESSMENT_JSP = "WEB-INF/view/pages/assessment.jsp";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();
    public static final String ASSESSMENT = "assessments";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter(Constant.STUDENT_ID));
        List<AssessmentTdo> allAssessment = studentService.getListOfStudentAssessment(studentId);
        request.getSession().setAttribute(ASSESSMENT, allAssessment);
        logger.trace(getClass().getSimpleName());
        request.getRequestDispatcher(WEB_INF_VIEW_PAGES_ASSESSMENT_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
