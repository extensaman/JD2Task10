package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.dto.StudentDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(StudentCommand.class);
    public static final String STUDENTS = "students";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(getClass().getSimpleName());
        List<StudentDto> allStudent = studentService.findAllStudentDto();
        req.getSession().setAttribute(STUDENTS, allStudent);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
