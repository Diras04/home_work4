package com.start.service;

import com.start.models.Courses;
import com.start.models.Person;
import com.start.models.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentsService<E> {

    public static Person createStudents() {

        return new Person("Andriy", "Derkach",
                "0977320951", "dira_s@gmail.com", Role.STUDENT);

    }

    public void printStudentsArray(List<Person> studentsArray) {
        Collections.sort(studentsArray, Person.personComparator);
        for (Person n : studentsArray) {

            System.out.println("Id - " + ((Person) n).getId() + "; First Name - " + ((Person) n).getName() + "; Last Name - "
                    + ((Person) n).getLastname() + "; Phone - " + ((Person) n).getPhone() + "; " +
                    "Email - " + ((Person) n).getEmail() + "; Role - " + ((Person) n).getRole());


        }

    }


}
