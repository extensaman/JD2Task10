package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.exception.EntityDaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * @param <T>
 */
public class EntityDaoImpl<T> implements EntityDao<T> {
    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger(EntityDaoImpl.class);
    /**
     *
     */
    protected final EntityManager entityManager;
    /**
     *
     */
    private final Class<T> aClass;

    /**
     * @param em
     * @param a
     */
    public EntityDaoImpl(final EntityManager em,
                         final Class<T> a) {
        this.entityManager = em;
        this.aClass = a;

    }

    /**
     * @param id
     * @return -
     */
    @Override
    public T findById(final Integer id) {
        T entity = null;
        try {
            entity = entityManager.find(aClass, id);
        } catch (IllegalArgumentException e) {
            throw new EntityDaoException(e);
        }
        return entity;
    }

    /**
     * @return -
     */
    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> rootEntry = criteriaQuery.from(aClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    /**
     * @param t
     */
    @Override
    public void save(final T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        }
    }

    /**
     * @param list
     */
    @Override
    public void save(final List<T> list) {
        try {
            entityManager.getTransaction().begin();
            list.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        }
    }

    /**
     * @param t
     */
    @Override
    public void update(final T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(final Integer id) {
        try {
            LOGGER.trace(getClass().getSimpleName() + " --- id for delete = " + id);
            T entity = entityManager.find(aClass, id);
            LOGGER.trace(getClass().getSimpleName() + " --- entity for delete = " + entity);
            System.out.println(getClass().getSimpleName() + " --- entity for delete = " + entity);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            LOGGER.trace(getClass().getSimpleName() + " --- entity is deleted");
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        }
    }

    @Override
    public void closeDao() {
        entityManager.close();
    }
}
