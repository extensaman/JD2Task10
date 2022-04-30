package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Task;

import javax.persistence.EntityManager;

public class TaskDaoImpl extends EntityDaoImpl<Task> implements TaskDao {

    public TaskDaoImpl(EntityManager em) {
        super(em, Task.class);
    }

}
