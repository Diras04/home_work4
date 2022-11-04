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

    public static void createCourses() {
        CoursesRepository cr = new CoursesRepository();
        LessonsRepository lesson = new LessonsRepository();
        StudentsRepository studentsRepository = new StudentsRepository();
        TeachersRepository teachersRepository = new TeachersRepository();
        CoursesService coursesService = new CoursesService();

        Lessons firstLesson = new Lessons("Discrete mathematics", "Page 25",
                "learn it");
        Students firstStudent = new Students("Bazaleev");
        Teachers firstTeacher = new Teachers("Simonova");
        cr.addCoursesToArray(new Courses("Math", firstLesson, firstStudent, firstTeacher));

        lesson.addLessonsToArray(firstLesson);
        teachersRepository.addTeachersToArray(firstTeacher);
        studentsRepository.addStudentsToArray(firstStudent);
        lesson.addLessonsToArray(new Lessons("An.Geomertry", "Page 28", "learn it"));
        lesson.addLessonsToArray(new Lessons("MathAn", "Page 29", "learn it"));
        coursesService.printCoursesArray(cr.getCoursesArray());

    }

    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - " + n.getName() + "; Lesson - " + n.getLessonsinfo() + "; Students - " +
                    n.getStudentinfo() + "; Teachers - " + n.getTeacherinfo());

        }

    }


}
