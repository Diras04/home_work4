package com.start.repository;


import com.start.models.Person;
import com.start.service.RepositoryService;

public class TeachersRepository extends RepositoryService {
    static int size = 0;


    int lenght = 1;
    Person[] TeachersArray = new Person[lenght];


    public void addTeachersToArray(Person courses) {


        if (size < TeachersArray.length) {
            TeachersArray[size] = courses;
        } else {
            addSizeArray();
            TeachersArray[size] = courses;

        }
        size++;


    }


    private void addSizeArray() {
        Person[] longTeachersArray = new Person[((TeachersArray.length) * 3 / 2) + 1];
        System.arraycopy(TeachersArray, 0, longTeachersArray, 0, TeachersArray.length);
        TeachersArray = longTeachersArray;


    }

    public Person[] getTeachersArray() {
        Person[] teachersArray1 = new Person[size];
        System.arraycopy(TeachersArray, 0, teachersArray1, 0, size);
        return teachersArray1;
    }
}
