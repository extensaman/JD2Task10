package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskCommand implements Command {
    private static final Logger logger = LogManager.getLogger(TaskCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.trace(getClass().getSimpleName());
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req,resp);
    }
}
