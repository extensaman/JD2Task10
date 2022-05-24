package by.it.academy.controller.command;

import by.it.academy.controller.command.impl.*;
import by.it.academy.controller.command.impl.mentor.MentorFindAllCommand;
import by.it.academy.controller.command.impl.mentor.MentorDeleteFromDbCommand;
import by.it.academy.controller.command.impl.mentor.MentorSaveFormCommand;
import by.it.academy.controller.command.impl.mentor.MentorSaveToDbCommand;
import by.it.academy.controller.command.impl.mentor.MentorUpdateFormCommand;
import by.it.academy.controller.command.impl.mentor.MentorUpdateToDbCommand;

public enum CommandEnum {
    HOME("Home", "pages/main.jspx", new HomeCommand()),
    STUDENT("Student", "pages/student.jsp", new StudentCommand()),
    MENTOR_FIND_ALL("Mentor", "pages/mentor.jsp", new MentorFindAllCommand()),
    MENTOR_SAVE_FORM("MentorSaveForm", "pages/mentorSaveForm.jsp", new MentorSaveFormCommand()),
    MENTOR_UPDATE_FORM("MentorUpdateForm", "pages/mentorUpdateForm.jsp", new MentorUpdateFormCommand()),
    MENTOR_UPDATE_TO_DB("MentorUpdateToDb", "pages/mentor.jsp", new MentorUpdateToDbCommand()),
    MENTOR_SAVE_TO_DB("MentorSaveToDb", "pages/mentor.jsp", new MentorSaveToDbCommand()),
    MENTOR_DELETE_FROM_DB("MentorDeleteFromDb", "pages/mentor.jsp", new MentorDeleteFromDbCommand()),
    COURSE("Course", "pages/course.jsp", new CourseCommand()),
    TASK("Task", "pages/task.jsp", new TaskCommand()),
    ASSESSMENT("assessment", "pages/assessment.jsp", new AssessmentCommand()),
    ADMIN("Admin", "pages/admin.jsp", new AdminCommand());


    private String pageName;
    private String pagePath;
    private Command command;

    CommandEnum(String pageName, String pagePath, Command command) {
        this.pageName = pageName;
        this.pagePath = pagePath;
        this.command = command;
    }

    public static CommandEnum selectCommand(String pageName) {
        for (CommandEnum type : CommandEnum.values()) {
            if (type.pageName.equalsIgnoreCase(pageName)) {
                return type;
            }
        }
        return HOME;
    }

    public String getPageName() {
        return pageName;
    }


    public String getPagePath() {
        return pagePath;
    }

    public Command getCommand() {
        return command;
    }
}
