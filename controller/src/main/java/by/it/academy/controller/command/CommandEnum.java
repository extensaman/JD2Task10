package by.it.academy.controller.command;

import by.it.academy.controller.command.impl.HomeCommand;
import by.it.academy.controller.command.impl.StudentCommand;

public enum CommandEnum {
    HOME("Home", "pages/main.jspx", new HomeCommand()),
    STUDENT("Student", "pages/student.jsp", new StudentCommand());

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
