package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.StudentDto;
import by.it.academy.services.dto.TaskDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TaskCommand implements Command {
    private static final Logger logger = LogManager.getLogger(TaskCommand.class);
    public static final String TASKS = "tasks";
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.trace(getClass().getSimpleName());
        List<TaskDto> allTask = taskService.findAllTaskDto();
        req.getSession().setAttribute(TASKS, allTask);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req,resp);
    }
}
