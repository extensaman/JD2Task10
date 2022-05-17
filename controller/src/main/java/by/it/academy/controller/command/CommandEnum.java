package by.it.academy.controller.command;

import by.it.academy.controller.command.impl.*;

public enum CommandEnum {
    HOME("Home", "pages/main.jspx", new HomeCommand()),
    STUDENT("Student", "pages/student.jsp", new StudentCommand()),
    MENTOR("Mentor", "pages/mentor.jsp", new MentorCommand()),
    COURSE("Course", "pages/course.jsp", new CourseCommand()),
    TASK("Task", "pages/task.jsp", new TaskCommand()),
    ADMIN("Admin", "pages/admin.jsp", new AdminCommand());
   // ADMIN_COURSE("AdminCourse", "pages/admin_course.jsp", new AdminCourseCommand());

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
