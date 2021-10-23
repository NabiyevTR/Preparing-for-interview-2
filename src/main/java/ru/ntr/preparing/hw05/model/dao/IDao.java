package ru.ntr.preparing.hw05.model.dao;

import ru.ntr.preparing.hw05.model.entity.Student;

import java.util.List;

public interface IDao<T> {
    void persist(T entity);

    void update(T entity);

    T findById(int id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
