package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.CourseDto;
import by.it.academy.services.dto.TaskDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TaskCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(TaskCommand.class);
    public static final String TASKS = "tasks";
    public static final String NAME = "Name";
    public static final String COURSE = "Course";
    public static final String COURSES = "courses";

    public static final String ASSESSMENT = "assessments";
    public static final String TASK_ID = "taskId";
    public static final String ACTION = "action";
    public static final String SAVE = "newTask";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String HOME_PAGE_NAME_TASK = "/home?pageName=task";
    private Integer taskId;
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Optional.ofNullable(req.getParameter(ACTION))
                .ifPresent(action -> {
                    switch (action) {
                        case SAVE:
                            String name = req.getParameter(NAME);
                            Integer course = Integer.valueOf(req.getParameter(COURSE));
                            taskService.createTask(name, course);
                            break;
                        case UPDATE:
                            taskId = Integer.valueOf(req.getParameter(TASK_ID));
                            String newName = req.getParameter(NAME);
                            Integer courseId = Integer.valueOf(req.getParameter(COURSE));
                            taskService.updateTask(taskId, newName, courseId);
                            break;
                        case DELETE:
                            Integer taskId = Integer.valueOf(req.getParameter(TASK_ID));
                            taskService.removeTask(taskId);
                            break;
                    }
                });
        LOGGER.trace(getClass().getSimpleName());
        List<CourseDto> courseDtos = courseService.findAllCourseDto();
        List<TaskDto> allTask = taskService.findAllTaskDto();
        req.getSession().setAttribute(COURSES, courseDtos);
        req.getSession().setAttribute(TASKS, allTask);
        if (req.getParameter(ACTION) == null) {
            req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
        }
        else {
            resp.sendRedirect(req.getContextPath() + HOME_PAGE_NAME_TASK);
        }
    }
}
