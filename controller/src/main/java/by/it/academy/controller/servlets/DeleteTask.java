package by.it.academy.controller;

import by.it.academy.services.ServiceProvider;
import by.it.academy.services.TaskService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "deleteTask", value = "/deleteTask")
public class DeleteTask extends HttpServlet {
    private final TaskService taskService = ServiceProvider.getInstance().taskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer taskId = Integer.valueOf(request.getParameter("taskId"));
            taskService.removeTask(taskId);
            response.sendRedirect(request.getContextPath() + "/home?pageName=task");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
