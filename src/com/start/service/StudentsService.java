package com.start.service;


import com.start.models.Person;
import com.start.models.Role;
import com.start.models.SuperObject;

public class StudentsService {

    public static Person createStudents() {
        Role role = Role.STUDENT;
        Person studentsServ = new Person("Andriy","Derkach",
                "0977320951","dira_s@gmail.com", role);
        return studentsServ;
    }

    public void printStudentsArray(Person[] StudentsArray) {
        for (Person n : StudentsArray) {

            System.out.println("Id - " + n.getId() + "; First Name - " + n.getName()+ "; Last Name - "
                    + n.getLastname()+ "; Phone - " + n.getPhone()+ "; Email - " + n.getEmail()+ "; Role - " + n.getRole());


        }

    }


}
