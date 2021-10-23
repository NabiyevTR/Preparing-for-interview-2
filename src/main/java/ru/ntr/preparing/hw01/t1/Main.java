package ru.ntr.preparing.hw01.t1;

public class Main {

    public static void main(String[] args) {

       Person person = Person.builder()
               .firstName("Mike")
               .lastName("Brown")
               .gender("Male")
               .age(20)
               .build();

       System.out.println(person);
    }
}
