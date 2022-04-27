package by.it.academy.repository.dao.exception;

public class EntityDaoException extends RuntimeException{
    public EntityDaoException() {
    }

    public EntityDaoException(String message) {
        super(message);
    }

    public EntityDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDaoException(Throwable cause) {
        super(cause);
    }
}
