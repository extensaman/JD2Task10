package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

public interface AdminService {

    /**
     *
     * @param nameCourse
     */
    public void createCourse(String nameCourse);

    /**
     *
     * @param idMentor
     */
    public void deleteMentorById(int idMentor);

    /**
     *
     */
    public void deleteMentorByName();

    /**
     *
     * @param nameMentor
     */
    public void createMentor(String nameMentor);

    /**
     *
     * @param idCourse
     */
    public void deleteCourseById(int idCourse);

    /**
     *
     */
    public void deleteCourseByName();

    /**
     *
     * @param idCourse
     * @param idMentor
     */
    public void insertMentorToCourse(int idCourse,int idMentor);

    /**
     *
     * @param idAdmin
     */
    public void takeCourseForControl(int idAdmin);

    /**
     *
     * @param idCourse
     * @param idMentor
     */
    public void updateMentorToCourse(int idCourse, int idMentor);

    /**
     *
     * @param idCourse
     * @param idAdmin
     */
    public void updateAdminToCourse(int idCourse, int idAdmin);
}
