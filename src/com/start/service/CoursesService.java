package com.start.service;

import com.start.models.*;
import com.start.repository.*;


public class CoursesService {
    RepositoryService lessonsRepository;
    RepositoryService studentsRepository;
    RepositoryService teachersRepository;
    RepositoryService coursesRepository;



    public CoursesService() {

    }

    public static void createCourses(RepositoryService lessonsRepository, RepositoryService studentsRepository,
                                     RepositoryService teachersRepository, RepositoryService coursesRepository) {

        RepositoryService repositoryService = new RepositoryService();
        RepositoryService homeworkRepository = new RepositoryService();
        CoursesService coursesService = new CoursesService();
        Person firstTeacher = new Person("Elena", "Simonova", "7531446",
                "simonova@gmail.com", Role.TEACHER);
        Lessons firstLesson = new Lessons("Discrete mathematics", (Homework[]) homeworkRepository.getAll(), "Page 26",
                firstTeacher, "learn it");
        Person firstStudent = new Person("Egor", "Bazaleev",
                "781543", "bazaleev@gmail.com", Role.STUDENT);


        coursesRepository.addObjectToArray(new Courses("Math", firstLesson, firstStudent));
        Person secondTeacher = new Person("Svitlana", "Kovalchik",
                "7885219", "kovalchik@gmail.com", Role.TEACHER);
        Person thirdTeacher = new Person("Galina", "Smirnova", "71228563",
                "smirnova@gmail.com", Role.TEACHER);

        lessonsRepository.addObjectToArray(firstLesson);
        teachersRepository.addObjectToArray(firstTeacher);
        studentsRepository.addObjectToArray(firstStudent);
        lessonsRepository.addObjectToArray(new Lessons("An.Geomertry", (Homework[]) homeworkRepository.getAll(), "Page 29",
                secondTeacher, "Learn it"));
        lessonsRepository.addObjectToArray(new Lessons("MathAn", (Homework[]) homeworkRepository.getAll(), "Page 30",
                thirdTeacher, "Learn it"));
        coursesService.printCoursesArray((Courses[]) coursesRepository.getAll());

    }

    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - "
                    + n.getName() + "; Lesson - " + n.getLessonsinfo() + "; Students - " +
                    n.getStudentinfo());

        }

    }


}
