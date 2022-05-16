package by.it.academy;

import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.entity.*;
import by.it.academy.services.impl.MentorServiceImpl;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MentorServiceTests {
    /*private static EntityDao<Course> courseDao;
    private static EntityDao<Task> taskDao;
    private static EntityDao<Assessment> assessmentDao;

    private static Task task;
    private static Course course;
    private static Assessment assessment;
    private static MentorServiceImpl ms;

    @BeforeClass
    public static void setUp() {
        courseDao = DaoProvider.getInstance().getCourseDao();
        taskDao = DaoProvider.getInstance().getTaskDao();
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        course = Course.builder().courseProgram("Da").build();
        task = Task.builder().description("Do it").build();
        assessment = Assessment.builder().feedback("good").mark(9).build();

        courseDao.save(course);

        ms = new MentorServiceImpl();

        courseDao.closeDao();
    }

    @Test
    public void t1_testCreateTask() {
        ms.createTask(1,task);

        Task taskFromDatabase = taskDao.findById(task.getTaskId());
        assertNotNull(taskFromDatabase);
        assertEquals(task.getTaskId(), taskFromDatabase.getTaskId());

        taskDao.closeDao();
        assessmentDao.closeDao();
    }

    @Test
    public void t2_testCreateAssessment() {
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        ms.createAssessment(1,assessment);

        Assessment assessmentFromDatabase = assessmentDao.findById(1);
        assertNotNull(assessmentFromDatabase);
        assertEquals(assessment.getId(), assessmentFromDatabase.getId());

        assessmentDao.closeDao();
    }

    @Test
    public void t3_testUpdateAssessment() {
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        assessment.setFeedback("not so good");
        assessment.setMark(7);
        ms.updateAssessment(assessment);

        Assessment assessmentFromDatabase = assessmentDao.findById(assessment.getId());
        assertNotNull(assessmentFromDatabase);
        assertEquals(assessment.getId(), assessmentFromDatabase.getId());
        assertEquals(7, (int)assessment.getMark());
        assertEquals("not so good", assessment.getFeedback());

        assessmentDao.closeDao();
    }

    @Test
    public void t4_testDeleteTask() {
        taskDao = DaoProvider.getInstance().getTaskDao();
        assessmentDao = DaoProvider.getInstance().getAssessmentDao();

        ms.deleteTask(task.getTaskId());

        Task taskFromDatabase = taskDao.findById(task.getTaskId());
        assertNull(taskFromDatabase);
        Assessment assessmentFromDatabase = assessmentDao.findById(assessment.getId());
        assertNull(assessmentFromDatabase);

        taskDao.closeDao();
        assessmentDao.closeDao();
    }*/
}
