package by.it.academy.controller.command.impl.mentor;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.services.MentorService;
import by.it.academy.services.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MentorUpdateToDbCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorUpdateToDbCommand.class);
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(getClass().getSimpleName() + " --- update Mentor");

        mentorService.update(req.getParameter(Constant.MENTOR_ID),
                req.getParameter(Constant.NAME),
                req.getParameterValues(Constant.COURSE_ID),
                req.getParameterValues(Constant.ADMIN_ID));
        resp.sendRedirect(req.getContextPath() + "/home?pageName=mentor");
    }
}
