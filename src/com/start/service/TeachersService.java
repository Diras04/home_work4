package com.start.service;

import com.start.models.Person;
import com.start.models.Role;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TeachersService {

    public static Person createTeachers() {

        return new Person("Genadiy", "Bilozerov",
                "5551287", "bilozerov@gmail.com", Role.TEACHER,1);

    }

    public void printTeachersArray(List<Person> teachersArray) {
        Optional<List<Person>> isNull = Optional.ofNullable(teachersArray);
        if (isNull.isPresent()) {
            Collections.sort(teachersArray, Person.personComparator);
            for (Person n : teachersArray) {

                System.out.println("Id - " + n.getId() + "; First Name - " + n.getName() + "; Last Name - "
                        + n.getLastname() + "; Phone - " + n.getPhone() + ";" +
                        " Email - " + n.getEmail() + "; Role - " + n.getRole() + "; Lessons ID - " + n.getRole());

            }

        }
    }

}
