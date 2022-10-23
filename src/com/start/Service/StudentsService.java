package com.start.Service;

import com.start.Courses.Students;
import com.start.Courses.Teachers;

import java.util.ArrayList;

public class StudentsService {
    ArrayList<Students> studentssarray;

    public StudentsService(ArrayList<Students> instudentsarray) {
        this.studentssarray = instudentsarray;

    }
    public static Students createStudents(){
        Students studentsServ = new Students("Derkach");
        return studentsServ;
    }

    public boolean removeStudents(int id) {
        for (Students e : studentssarray)
            if (e.getId() == id) {
                studentssarray.remove(e);
                if (studentssarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;


    }

    public boolean removeStudents(String name) {
        for (Students e : studentssarray)
            if (e.getName() == name) {
                studentssarray.remove(e);
                if (studentssarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;

    }

    public boolean addStudents(Students inStudents) {
        this.studentssarray.add(inStudents);
        if (studentssarray.indexOf(inStudents) == -1) {
            return false;
        }
        return true;
    }


    public ArrayList<Students> getArray() {
        return this.studentssarray;

    }

    public Students getByName(String name) {
        for (Students e : studentssarray) {
            if (e.getName() == name)
                return e;
        }
        return null;
    }

    public Students getByid(int id) {
        for (Students e : studentssarray)
            if (e.getId() == id)
                return e;
        return null;
    }

    @Override
    public String toString() {
        return "StudentsService{" +
                "studentssarray=" + studentssarray +
                '}';
    }
}
