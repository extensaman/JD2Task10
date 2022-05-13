package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.repository.entity.Student;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentCommand implements Command {
    public static final String MAIN_PAGE = "/WEB-INF/view/layout/template.jspx";
    public static final String STUDENTS = "students";
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("From StudentCommand");
        List<Student> allStudent = studentService.findAllStudent();
        System.out.println(allStudent);
        req.getSession().setAttribute(STUDENTS, allStudent);
        req.getRequestDispatcher(MAIN_PAGE).forward(req,resp);
    }
}
