package com.start.service;


import com.start.models.Person;
import com.start.models.Role;
import com.start.models.SuperObject;

import java.util.ArrayList;

public class TeachersService<E> {

    public static Person createTeachers() {

        Person teachersServ = new Person("Genadiy","Bilozerov",
                "5551287","bilozerov@gmail.com",Role.TEACHER);
        return teachersServ;
    }

    public void printTeachersArray(ArrayList<E> teachersArray) {
        for (E n : teachersArray) {

            System.out.println("Id - " + ((Person)n).getId() + "; First Name - " + ((Person)n).getName()+ "; Last Name - "
                    + ((Person)n).getLastname()+ "; Phone - " + ((Person)n).getPhone()+ "; Email - " + ((Person)n).getEmail()+ "; Role - " + ((Person)n).getRole());

        }

    }


}
