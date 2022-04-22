package by.it.academy.repository.dao.impl;

import by.it.academy.repository.dao.EntityDao;
import by.it.academy.repository.dao.EntityDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    private final EntityManagerFactory factory;
    /**
     *
     */
    private final Class<T> aClass;

    /**
     * @param f
     * @param a
     */
    public EntityDaoImpl(final EntityManagerFactory f,
                         final Class<T> a) {
        this.factory = f;
        this.aClass = a;
    }

    /**
     * @return -
     */
    protected EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * @param id
     * @return -
     */
    @Override
    public T findById(final Integer id) {
        EntityManager entityManager = factory.createEntityManager();
        T entity = null;
        try {
            entity = entityManager.find(aClass, id);
        } catch (IllegalArgumentException e) {
            throw new EntityDaoException(e);
        } finally {
            entityManager.close();
        }
        return entity;
    }

    /**
     * @return -
     */
    @Override
    public List<T> findAll() {
        EntityManager entityManager = factory.createEntityManager();
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
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param list
     */
    @Override
    public void save(final List<T> list) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            list.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param t
     */
    @Override
    public void update(final T t) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(final Integer id) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            T entity = entityManager.find(aClass, id);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new EntityDaoException(e);
        } finally {
            entityManager.close();
        }
    }
}
