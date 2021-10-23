package ru.ntr.preparing.hw05.model.dao;

import org.hibernate.Session;

import java.util.List;

import static ru.ntr.preparing.hw05.config.HibernateUtil.getCurrentSession;

public class AbstractDao<T>  implements IDao<T>{

    private Class<T> clazz;

    public void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    @Override
    public void persist(T entity) {
        Session currentSession = getCurrentSession();
        getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public T findById(int id) {
        return (T) getCurrentSession().get(clazz , id);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    @Override
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }
}
