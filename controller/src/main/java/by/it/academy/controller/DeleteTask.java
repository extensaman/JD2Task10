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
        String command = request.getParameter("command");
        Integer taskId = Integer.valueOf(request.getParameter("taskId"));
        if (Objects.equals(command, "delete")) {
            taskService.removeTask(taskId);
            System.out.println("del");
            response.sendRedirect(request.getContextPath() + "/home?pageName=task");
            /*request.getRequestDispatcher("/home?pageName=task").forward(request, response);*/
        } /*else if (Objects.equals(command, "newTask")) {
            request.getRequestDispatcher("WEB-INF/view/pages/newTask.jsp").forward(request, response);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
