package by.it.academy.controller.command.impl.mentor;

import by.it.academy.controller.command.Command;
import by.it.academy.controller.command.Constant;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.services.AdminService;
import by.it.academy.services.CourseService;
import by.it.academy.services.MentorService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminForMentorDto;
import by.it.academy.services.dto.CourseForMentorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MentorUpdateFormCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MentorUpdateFormCommand.class);
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();
    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();
    private final MentorService mentorService = ServiceProvider.getInstance().getMentorService();
    private List<CourseForMentorDto> allCourseForMentor;
    private List<AdminForMentorDto> allAdminForMentor;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Optional.ofNullable(req.getParameter(Constant.MENTOR_ID))
                .ifPresent(id ->
                {
                    allCourseForMentor = courseService
                            .findAllCourseForExistingMentor(Integer.parseInt(id));
                    allAdminForMentor = adminService
                            .findAllAdminForMentorWithCheckedExisting(Integer.parseInt(id));
                    String updatableMentorName = mentorService.findMentorById(Integer.parseInt(id))
                            .map(Mentor::getMentorName)
                            .orElse(Constant.EMPTY_STRING);
                    req.getSession().setAttribute(Constant.MENTOR_ID, id);
                    req.getSession().setAttribute(Constant.MENTOR_NAME_FOR_UPDATE, updatableMentorName);
                    req.getSession().setAttribute(Constant.ALL_COURSE_FOR_MENTOR, allCourseForMentor);
                    req.getSession().setAttribute(Constant.ALL_ADMIN_FOR_MENTOR, allAdminForMentor);
                });
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
