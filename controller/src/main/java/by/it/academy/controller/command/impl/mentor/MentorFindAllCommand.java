package by.it.academy.controller.command.impl.mentor;

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

public class MentorFindAllCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorFindAllCommand.class);
    public static final String ACTION = "action";
    public static final String DESCRIPTION = "description";
    public static final String SAVE = "save";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Mentor> allMentor = mentorService.findAllMentor();
        LOGGER.trace(getClass().getSimpleName() + " --- allMentor = " + allMentor);
        req.getSession().setAttribute(Constant.MENTORS, allMentor);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
