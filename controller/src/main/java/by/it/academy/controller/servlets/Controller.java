package by.it.academy.controller.servlets;

import by.it.academy.controller.command.CommandEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/home")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    public static final String PAGE_NAME = "pageName";
    public static final String HOME = "home";
    public static final String PAGE_PATH_ATTR = "pagePath";
    public static final String TITLE_ATTR = "title";
    public static final String PREV_PAGE_ATTR = "prevPage";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageName = Optional.ofNullable(req.getParameter(PAGE_NAME))
                .filter(s -> !s.isEmpty())
                .orElse(HOME);
        LOGGER.trace(getClass().getSimpleName() + " *** pageName = " + pageName);
        HttpSession session = req.getSession();
        CommandEnum command = CommandEnum.selectCommand(pageName);
        session.setAttribute(PAGE_PATH_ATTR,command.getPagePath());
        req.setAttribute(TITLE_ATTR,command.getPageName());
        command.getCommand().execute(req,resp);
        session.setAttribute(PREV_PAGE_ATTR,pageName);
    }
}
