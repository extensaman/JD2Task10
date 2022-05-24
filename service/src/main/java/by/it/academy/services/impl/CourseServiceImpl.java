package by.it.academy.services.impl;

import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.MentorDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.services.CourseService;
import by.it.academy.services.dto.CourseDto;
import by.it.academy.services.dto.CourseForMentorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private static final String CHECKED = "checked";
    private static final String NOT_CHECKED = "";

    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = null;
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        courses = courseDao.findAll();
        courseDao.closeDao();
        return courses;
    }

    @Override
    public List<CourseDto> findAllCourseDto() {
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        List<CourseDto> courses = null;
        courses = courseDao.findAll()
                .stream()
                .map(CourseDto::new)
                .collect(Collectors.toList());
        courseDao.closeDao();
        return courses;
    }

    @Override
    public List<Course> findAllCourseWithoutMentor() {
        return findAllCourse().stream()
                .filter(course -> course.getMentorField() == null)
                .collect(Collectors.toList());
    }

    @Override
    public void createCourse(String nameCourse) {
        EntityDao<Course> courseEntityDao = DaoProvider.getInstance().getCourseDao();
        Course newCourse = Course.builder()
                .courseProgram(nameCourse)
                .build();
        courseEntityDao.save(newCourse);
        courseEntityDao.closeDao();
    }

    @Override
    public List<CourseForMentorDto> findAllCourseWithoutAnyMentor() {
        return findAllCourse().stream()
                .filter(course -> course.getMentorField() == null)
                .map(course -> CourseForMentorDto.builder()
                        .id(course.getId())
                        .courseProgram(course.getCourseProgram())
                        .checked(NOT_CHECKED)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseForMentorDto> findAllCourseForExistingMentor(Integer mentorId) {
        List<CourseForMentorDto> currentCoursesOfExistingMentor;
        MentorDao mentorDao = DaoProvider.getInstance().getMentorDao();

        currentCoursesOfExistingMentor = mentorDao.findMentorById(mentorId)
                .map(mentor ->
                        Optional.ofNullable(mentor.getCourses())
                                .map(courses -> courses.stream()
                                        .map(course -> CourseForMentorDto.builder()
                                                .id(course.getId())
                                                .courseProgram(course.getCourseProgram())
                                                .checked(CHECKED)
                                                .build())
                                        .collect(Collectors.toList()))
                                .orElse(new ArrayList<>())
                ).orElse(new ArrayList<>());

        List<CourseForMentorDto> result = new ArrayList<>();
        result.addAll(currentCoursesOfExistingMentor);
        result.addAll(findAllCourseWithoutAnyMentor());
        mentorDao.closeDao();
        return result;
    }
}
