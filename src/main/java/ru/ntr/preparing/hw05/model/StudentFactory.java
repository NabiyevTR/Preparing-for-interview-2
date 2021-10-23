package ru.ntr.preparing.hw05.model;

import lombok.Getter;
import ru.ntr.preparing.hw05.model.entity.Student;

import java.util.Random;

public class StudentFactory {

    private static int counter = 0;

    private enum MARKS {
        A_PLUS("A+"), A("A"), B("B"), C("C"), D("D"), F("F");

        @Getter
        private String mark;

        MARKS(String mark) {
            this.mark = mark;
        }
    }

    public static Student createStudent() {
        Student student = new Student();
        student.setName("Student" + (++counter));
        student.setMark(getRandomMark());
        return student;
    }

    private static String getRandomMark() {
        Random random = new Random();
        int randomIdx = random.nextInt(MARKS.values().length);
        return MARKS.values()[randomIdx].getMark();
    }
}
