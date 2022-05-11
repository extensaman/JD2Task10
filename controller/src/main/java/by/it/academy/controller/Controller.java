package by.it.academy.controller;

import by.it.academy.controller.command.CommandEnum;

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

    public static final String PAGE_NAME = "pageName";
    public static final String HOME = "home";
    public static final String PAGE_PATH = "pagePath";
    public static final String TITLE = "title";
    public static final String PREV_PAGE = "prevPage";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In SERVICE!!!");
        String pageName = Optional.ofNullable(req.getParameter(PAGE_NAME))
                .filter(String::isEmpty)
                .orElse(HOME);
        HttpSession session = req.getSession();
        CommandEnum command = CommandEnum.selectCommand(pageName);
        session.setAttribute(PAGE_PATH,command.getPagePath());
        req.setAttribute(TITLE,command.getPageName());
        command.getCommand().execute(req,resp);
        session.setAttribute(PREV_PAGE,pageName);
    }
}
