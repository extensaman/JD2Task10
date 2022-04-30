package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;

public interface AdminService {

    /**
     *
     * @param nameCourse
     */
    void createCourse(String nameCourse) throws SecurityException;

    /**
     *
     * @param idMentor
     */
    void deleteMentorById(int idMentor) throws SecurityException;

    /**
     *
     */
    void deleteMentorByName() throws SecurityException;

    /**
     *
     * @param nameMentor
     */
    void createMentor(String nameMentor) throws SecurityException;

    /**
     *
     * @param idCourse
     */
    void deleteCourseById(int idCourse) throws SecurityException;

    /**
     *
     */
    void deleteCourseByName() throws SecurityException;

    /**
     *
     * @param idCourse
     * @param idMentor
     */
    void insertMentorToCourse(int idCourse,int idMentor) throws SecurityException;

    /**
     *
     * @param idAdmin
     */
    void takeCourseForControl(int idAdmin) throws SecurityException;

    /**
     *
     * @param idCourse
     * @param idMentor
     */
    void updateMentorToCourse(int idCourse, int idMentor) throws SecurityException;

    /**
     *
     * @param idCourse
     * @param idAdmin
     */
    void updateAdminToCourse(int idCourse, int idAdmin) throws SecurityException;
}
