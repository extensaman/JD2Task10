package by.it.academy.controller.command.impl;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.MentorService;
import by.it.academy.services.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MentorCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorCommand.class);
    public static final String MENTORS = "mentors";
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Mentor> allMentor = mentorService.findAllMentor();
        LOGGER.trace(getClass().getSimpleName() + " --- allMentor = " + allMentor);
        req.getSession().setAttribute(MENTORS, allMentor);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
