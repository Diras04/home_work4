package com.start.serializbl;

import com.start.models.Courses;
import com.start.models.Lessons;
import com.start.models.Person;
import com.start.models.SuperObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortCourses implements Serializable {
    public String name;
    public int iD;
    public List<SuperObject> allCourses= new ArrayList<>();
    
    public void sort(Courses courses, List<Lessons> lessons, List<Person> students){
        name = courses.getName();
        iD = courses.getId();
        for (Lessons n:lessons ) {
            if (courses.getId()==n.getCourseId()){
                allCourses.add(n);
            }
        }
        for (Person n:students ) {
            if (courses.getId()==n.getFatherId()){
                allCourses.add(n);
            }
        }
    }

    @Override
    public String toString() {
        return "SortCourses{" +
                "name='" + name + '\'' +
                ", iD=" + iD +
                ", allCourses=" + allCourses +
                '}';
    }
}
