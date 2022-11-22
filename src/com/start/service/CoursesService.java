package com.start.service;

import com.start.courses.Courses;
import com.start.courses.Lessons;
import com.start.courses.Teachers;
import com.start.courses.Students;
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
        Lessons firstLesson = new Lessons("Discrete mathematics", "Page 25",
                "learn it");
        Students firstStudent = new Students("Bazaleev");
        Teachers firstTeacher = new Teachers("Simonova");

        coursesRepository.addCoursesToArray(new Courses("Math", firstLesson, firstStudent, firstTeacher));

        lessonsRepository.addLessonsToArray(firstLesson);
        teachersRepository.addTeachersToArray(firstTeacher);
        studentsRepository.addStudentsToArray(firstStudent);
        lessonsRepository.addLessonsToArray(new Lessons("An.Geomertry", "Page 28", "learn it"));
        lessonsRepository.addLessonsToArray(new Lessons("MathAn", "Page 29", "learn it"));
        coursesService.printCoursesArray(coursesRepository.getAll());

    }

    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - " + n.getName() + "; Lesson - " + n.getLessonsinfo() + "; Students - " +
                    n.getStudentinfo() + "; Teachers - " + n.getTeacherinfo());

        }

    }


}
