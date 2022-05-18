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
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MentorCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorCommand.class);
    public static final String MENTORS = "mentors";
    public static final String ACTION = "action";
    public static final String DESCRIPTION = "description";
    public static final String SAVE = "save";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String COURSE_ID = "courseId";
    public static final String ADMIN_ID = "adminId";
    public static final String NAME = "name";
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.trace(req.getParameter(ACTION));
        LOGGER.trace(req.getParameter(DESCRIPTION));

        Optional.ofNullable(req.getParameter(ACTION))
                .ifPresent(action -> {
                    switch (action) {
                        case SAVE:
                            mentorService.save(req.getParameter(NAME),
                                    req.getParameterValues(COURSE_ID),
                                    req.getParameterValues(ADMIN_ID));
                            break;
                        case UPDATE:
                            break;
                        case DELETE:
                            Optional.ofNullable(req.getParameter(DESCRIPTION))
                                    .ifPresent(s ->
                                    {
                                        LOGGER.trace(getClass().getSimpleName() + " --- ID for delete = " + s);
                                        mentorService.deleteById(Integer.parseInt(s));
                                    });
                            break;
                    }
                });

        List<Mentor> allMentor = mentorService.findAllMentor();
        LOGGER.trace(getClass().getSimpleName() + " --- allMentor = " + allMentor);
        req.getSession().setAttribute(MENTORS, allMentor);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
