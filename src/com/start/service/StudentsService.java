package com.start.service;

import com.start.models.Person;
import com.start.models.Role;

import java.util.Collections;
import java.util.List;

public class StudentsService {

    public static Person createStudents() {

        return new Person("Andriy", "Derkach",
                "0977320951", "dira_s@gmail.com", Role.STUDENT);

    }

    public void printStudentsArray(List<Person> studentsArray) {
        Collections.sort(studentsArray, Person.personComparator);
        for (Person n : studentsArray) {

            System.out.println("Id - " + n.getId() + "; First Name - " + n.getName() + "; Last Name - "
                    + n.getLastname() + "; Phone - " + n.getPhone() + "; " +
                    "Email - " + n.getEmail() + "; Role - " + n.getRole());


        }

    }


}
