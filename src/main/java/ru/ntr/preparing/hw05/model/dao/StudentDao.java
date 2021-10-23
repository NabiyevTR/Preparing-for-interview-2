package ru.ntr.preparing.hw05.model.dao;

import org.springframework.stereotype.Repository;
import ru.ntr.preparing.hw05.model.entity.Student;

@Repository
public class StudentDao extends AbstractDao<Student> {
    {
        setClazz(Student.class);
    }
}

