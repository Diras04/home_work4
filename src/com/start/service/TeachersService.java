package com.start.service;

import com.start.models.Person;
import com.start.models.Role;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeachersService<E> {

    public static Person createTeachers() {

        return new Person("Genadiy", "Bilozerov",
                "5551287", "bilozerov@gmail.com", Role.TEACHER);

    }

    public void printTeachersArray(List<Person> teachersArray) {
        Collections.sort(teachersArray, Person.personComparator);
        for (Person n : teachersArray) {

            System.out.println("Id - " +  n.getId() + "; First Name - " + n.getName() + "; Last Name - "
                    +  n.getLastname() + "; Phone - " +  n.getPhone() + ";" +
                    " Email - " + n.getEmail() + "; Role - " + n.getRole());

        }

    }


}
