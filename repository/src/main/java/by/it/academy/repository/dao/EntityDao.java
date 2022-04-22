package by.it.academy.repository.dao;

import java.util.List;

/**
 * @param <T>
 */
public interface EntityDao<T> {
    /**
     * @param id
     * @return -
     */
    T findById(Integer id);

    /**
     * @return -
     */
    List<T> findAll();

    /**
     * @param t
     */
    void save(T t);

    /**
     * @param list
     */
    void save(List<T> list);

    /**
     * @param t
     */
    void update(T t);

    /**
     * @param id
     */
    void delete(Integer id);
}
