package ru.ntr.preparing.hw01.t1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Person person;

        public Builder() {
            person = new Person(
                    "Undefined",
                    "Undefined",
                    "Undefined",
                    "Undefined",
                    "Undefined",
                    "Undefined",
                    0,
                    "Undefined");
        }

        public Builder firstName(String firstName) {
           person.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            person.middleName = middleName;
            return this;
        }

        public Builder country(String country) {
            person.country = country;
            return this;
        }

        public Builder address(String address) {
            person.address = address;
            return this;
        }

        public Builder phone(String phone) {
            person.phone = phone;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
            return this;
        }

        public Builder gender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person build() {
            return person;
        }
    }


}
