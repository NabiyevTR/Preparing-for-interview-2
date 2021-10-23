package ru.ntr.preparing.hw05;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ntr.preparing.hw05.config.HibernateUtil;
import ru.ntr.preparing.hw05.model.dao.StudentDao;
import ru.ntr.preparing.hw05.model.StudentFactory;
import ru.ntr.preparing.hw05.model.entity.Student;

@SpringBootApplication
@RequiredArgsConstructor
public class HibernateApp implements CommandLineRunner {

    private final StudentDao studentDao;
    private static final int STUDENTS_AMOUNT = 1000;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //add students to db
        HibernateUtil.openCurrentSessionWithTransaction();
        //studentDao.deleteAll();
        for (int i = 0; i < STUDENTS_AMOUNT; i++) {
            studentDao.persist(StudentFactory.createStudent());
        }
        HibernateUtil.closeCurrentSessionWithTransaction();

        // get student from db and update
        HibernateUtil.openCurrentSessionWithTransaction();
        Student student = studentDao.findById(3695);
        System.out.println(student);
        student.setMark("A+");
        studentDao.update(student);
        HibernateUtil.closeCurrentSessionWithTransaction();

        //check update
        HibernateUtil.openCurrentSessionWithTransaction();
        System.out.println(studentDao.findById(3695));
        HibernateUtil.closeCurrentSessionWithTransaction();

        //read students from db
        HibernateUtil.openCurrentSessionWithTransaction();
        studentDao.findAll().forEach(System.out::println);
        HibernateUtil.openCurrentSessionWithTransaction();
    }
}
