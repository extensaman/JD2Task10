package by.it.academy.repository;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.MentorDao;

public class App {
    public static void main(String[] args) {
        System.out.println("Start!");
        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();
        mentorDao.delete(1);
        mentorDao.closeDao();
        System.out.println("Finish!");
    }
}
