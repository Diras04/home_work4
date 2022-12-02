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
        Person firstTeacher = new Person("Elena","Simonova","7531446",
                "simonova@gmail.com", Role.TEACHER);
        Lessons firstLesson = new Lessons("Discrete mathematics","Page25", "Page 26",
                firstTeacher,"learn it" );
        Person firstStudent = new Person("Egor","Bazaleev",
                "781543","bazaleev@gmail.com", Role.STUDENT);


        coursesRepository.addCoursesToArray(new Courses("Math", firstLesson, firstStudent));
        Person secondTeacher = new Person("Svitlana","Kovalchik",
                "7885219","kovalchik@gmail.com",Role.TEACHER);
        Person thirdTeacher = new Person("Galina","Smirnova","71228563",
                "smirnova@gmail.com",Role.TEACHER);

        lessonsRepository.addLessonsToArray(firstLesson);
        teachersRepository.addTeachersToArray(firstTeacher);
        studentsRepository.addStudentsToArray(firstStudent);
        lessonsRepository.addLessonsToArray(new Lessons("An.Geomertry", "Page 28","Page 29",
                secondTeacher,"Learn it" ));
        lessonsRepository.addLessonsToArray(new Lessons("MathAn", "Page 29","Page 30",
                thirdTeacher,"Learn it" ));
        coursesService.printCoursesArray(coursesRepository.getAll());

    }

    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - "
                    + n.getName() + "; Lesson - " + n.getLessonsinfo() + "; Students - " +
                    n.getStudentinfo() );

        }

    }


}
