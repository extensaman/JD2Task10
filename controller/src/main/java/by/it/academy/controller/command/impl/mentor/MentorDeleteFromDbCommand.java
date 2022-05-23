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
import java.util.Optional;

public class MentorDeleteFromDbCommand implements Command {
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();
    private static final Logger LOGGER = LogManager.getLogger(MentorDeleteFromDbCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Optional.ofNullable(req.getParameter(Constant.MENTOR_ID))
                .ifPresent(id ->
                {
                    LOGGER.trace(getClass().getSimpleName() + " --- ID for delete = " + id);
                    mentorService.deleteById(Integer.parseInt(id));
                });
        resp.sendRedirect(req.getContextPath() + "/home?pageName=mentor");
    }
}
