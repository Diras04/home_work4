package com.start.service;

import com.start.courses.Courses;
import com.start.courses.Lessons;
import com.start.courses.Person;
import com.start.courses.Role;
import com.start.repository.CoursesRepository;
import com.start.repository.LessonsRepository;
import com.start.repository.StudentsRepository;
import com.start.repository.TeachersRepository;


public class CoursesService {
    LessonsRepository lessonsRepository;
    StudentsRepository studentsRepository;
    TeachersRepository teachersRepository;
    CoursesRepository coursesRepository;


    public CoursesService() {

    }

    public static void createCourses(LessonsRepository lessonsRepository, StudentsRepository studentsRepository,
                                     TeachersRepository teachersRepository,CoursesRepository coursesRepository) {


        CoursesService coursesService = new CoursesService();
        Person firstTeacher = new Person("Simonova", Role.TEACHER);
        Lessons firstLesson = new Lessons("Discrete mathematics", "Page 25",
                "learn it", firstTeacher);
        Person firstStudent = new Person("Bazaleev", Role.STUDENT);


        coursesRepository.addCoursesToArray(new Courses("Math", firstLesson, firstStudent));
        Person secondTeacher = new Person("Babka", Role.TEACHER);
        Person thirdTeacher = new Person("Smirnov", Role.TEACHER);

        lessonsRepository.addLessonsToArray(firstLesson);
        teachersRepository.addTeachersToArray(firstTeacher);
        studentsRepository.addStudentsToArray(firstStudent);
        lessonsRepository.addLessonsToArray(new Lessons("An.Geomertry", "Page 28", "learn it", secondTeacher));
        lessonsRepository.addLessonsToArray(new Lessons("MathAn", "Page 29", "learn it", thirdTeacher));
        coursesService.printCoursesArray(coursesRepository.getAll());

    }

    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - " + n.getName() + "; Lesson - " + n.getLessonsinfo() + "; Students - " +
                    n.getStudentinfo() );

        }

    }


}
