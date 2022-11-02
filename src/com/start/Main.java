package com.start;

import com.start.courses.Courses;
import com.start.courses.Lessons;
import com.start.courses.Students;
import com.start.courses.Teachers;
import com.start.repository.CoursesRepository;
import com.start.repository.LessonsRepository;
import com.start.repository.TeachersRepository;
import com.start.repository.StudentsRepository;
import com.start.service.LessonsService;
import com.start.service.TeachersService;
import com.start.service.StudentsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        CoursesRepository cr = new CoursesRepository();
        LessonsRepository lesson = new LessonsRepository();
        TeachersRepository teachersRepository = new
                TeachersRepository();
        StudentsRepository studentsRepository = new StudentsRepository();
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (k != 5) {
            System.out.println("Select a category");
            System.out.println("Courses - press 1");
            System.out.println("Teacher - press 2");
            System.out.println("Students - press 3");
            System.out.println("Lessons create - press 4");
            System.out.println("Show all - press 6");
            System.out.println("Exit - prees 5");

            k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:


                    Lessons firstLesson;
                    Students firstStudent;
                    Teachers firstTeacher;
                    cr.addCoursesToArray(new Courses("Math", firstLesson = new Lessons("Discrete mathematics", "Page 25",
                            "learn it"), firstStudent = new Students("Bazaleev"), firstTeacher = new Teachers("Simonova")));

                    lesson.addLessonsToArray(firstLesson);
                    teachersRepository.addTeachersToArray(firstTeacher);
                    studentsRepository.addStudentsToArray(firstStudent);
                    lesson.addLessonsToArray(new Lessons("An.Geomertry", "Page 28", "learn it"));
                    lesson.addLessonsToArray(new Lessons("MathAn", "Page 29", "learn it"));
                    System.out.println(Arrays.toString(cr.getCoursesArray()));
                    break;
                case 2:
                    teachersRepository.addTeachersToArray(TeachersService.createTeachers());
                    System.out.println(Arrays.toString(teachersRepository.getTeachersArray()));
                    break;
                case 3:
                   studentsRepository.addStudentsToArray(StudentsService.createStudents());
                    System.out.println(Arrays.toString(studentsRepository.getStudentsArray()));
                    break;
                case 4:
                    for (int i = 1; i <= 8; i++) {

                        System.out.println("Enter the title of the lecture, or enter stop to go main menu");
                        String name = scanner.nextLine();


                        if (name.equals("stop")) {

                            break;
                        }


                        System.out.println("Enter the home work");
                        String homeWork = scanner.nextLine();
                        System.out.println("Enter the dopinfo");
                        String dopInfo = scanner.nextLine();

                        lesson.addLessonsToArray(new Lessons(name, homeWork, dopInfo));
                        System.out.println(Arrays.toString(lesson.getLessonsArray()));
                        System.out.println("Count of Lessons - " + Lessons.idstatik);
                    }
                    break;


                case 5:
                    break;
                case 6:
                    System.out.print("Base Courses ---");
                    System.out.println(Arrays.toString(cr.getCoursesArray()));
                    System.out.print("Base Lessons ---");
                    System.out.println(Arrays.toString(lesson.getLessonsArray()));
                    System.out.print("Base Stedents ---");
                    System.out.println(Arrays.toString(studentsRepository.getStudentsArray()));
                    System.out.print("Base Teachers ---");
                    System.out.println(Arrays.toString(teachersRepository.getTeachersArray()));
                    break;
                default:
                    System.out.println("____________________Make the right choice!!!!!!");


            }
            if (Lessons.idstatik == 8) {
                break;
            }

        }
    }
}

