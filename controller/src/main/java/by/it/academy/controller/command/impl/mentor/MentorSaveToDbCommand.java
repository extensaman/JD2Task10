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

public class MentorSaveToDbCommand implements Command {
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();
    private static final Logger LOGGER = LogManager.getLogger(MentorSaveToDbCommand.class);


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        mentorService.save(req.getParameter(Constant.NAME),
                req.getParameterValues(Constant.COURSE_ID),
                req.getParameterValues(Constant.ADMIN_ID));
        LOGGER.trace(getClass().getSimpleName() + " --- Mentor " + req.getParameter(Constant.NAME) + " saved to DB");
        resp.sendRedirect(req.getContextPath() + "/home?pageName=mentor");
    }
}
