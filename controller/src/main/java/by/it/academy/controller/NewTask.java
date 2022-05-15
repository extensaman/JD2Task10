package by.it.academy.controller;

import by.it.academy.services.dto.AssessmentTdo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "newTask", value = "/newTask")
public class NewTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>First</title></head>");
        printWriter.println("<body><h1>Hello</h1>");
        printWriter.println("</body></html>");
        /*Integer taskId = Integer.valueOf(request.getParameter("taskId"));
        List<AssessmentTdo> allAssessment = taskService.getListOfTaskAssessment(taskId);
        request.getSession().setAttribute(ASSESSMENT,allAssessment);
        logger.trace(getClass().getSimpleName());
        request.getRequestDispatcher("WEB-INF/view/pages/assessment.jsp").forward(request,response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
