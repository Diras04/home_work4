package com.start.service;


import com.start.courses.Lessons;
import com.start.courses.Person;
import com.start.courses.Role;
import com.start.repository.CoursesRepository;
import com.start.repository.LessonsRepository;
import com.start.repository.StudentsRepository;
import com.start.repository.TeachersRepository;


import java.util.Scanner;

public class Menu {

    public void mainMenu() {
        LessonsService lessonsService = new LessonsService();
        StudentsService studentsService = new StudentsService();
        TeachersService teachersService = new TeachersService();
        CoursesService coursesService = new CoursesService();
        CoursesRepository cr = new CoursesRepository();
        LessonsRepository lesson = new LessonsRepository();
        TeachersRepository teachersRepository = new
                TeachersRepository();
        StudentsRepository studentsRepository = new StudentsRepository();
        Scanner scanner = new Scanner(System.in);

        int k = 0;
        while (k != 5) {
            System.out.println("Select a category:");
            System.out.println("Create course & 3 lessons - press 1 *** ");
            System.out.println("Create Teacher from servise - press 2 *** ");
            System.out.println("Create Students from servise - press 3 *** ");
            System.out.println("Lessons create from terminal - press 4 *** ");
            System.out.println("Show all Lessons - press 6 *** ");
            System.out.println("Show all Students - press 7 *** ");
            System.out.println("Show all Teachers - press 8 *** ");
            System.out.println("Show all Courses - press 9 *** ");
            System.out.println("Find Lesson by Id - press 10 ***");
            System.out.println("Delete Lesson by id - press 11 ***");
            System.out.println("Exit - prees 5");

            k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    CoursesService.createCourses(lesson,studentsRepository,teachersRepository,cr);
                    break;
                case 2:
                    teachersRepository.addTeachersToArray(TeachersService.createTeachers());
                    break;
                case 3:
                    studentsRepository.addStudentsToArray(StudentsService.createStudents());
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
                        System.out.println("Enter teachers name");
                        String teachname = scanner.nextLine();
                       Person person = new Person(teachname, Role.TEACHER);
                        int courseId = 0;

                        if (cr.getAll().length > 0) {
                            while (true) {
                                System.out.println("All created Courses:");
                                coursesService.printCoursesArray(cr.getAll());

                                System.out.println("Enter the course ID");


                                courseId = scanner.nextInt();
                                scanner.nextLine();
                                if (cr.checkId(courseId)) {
                                    break;
                                }
                                System.out.println("Current IDcourse does not exist. Please try again");

                            }
                        }

                        Lessons L = new Lessons(name, homeWork, dopInfo,person);
                        L.setCourseId(courseId);

                        lesson.addLessonsToArray(L);
                        System.out.println("Lessons:");

                        lessonsService.printLessonsArray(lesson.getAll());
                        System.out.println("Count of Lessons - " + Lessons.idstatik);
                    }
                    break;


                case 5:
                    break;
                case 6:
                    System.out.println("Base Lessons:");
                    lessonsService.printLessonsArray(lesson.getAll());
                    break;
                case 7:
                    System.out.println("Base Students:");
                    studentsService.printStudentsArray(studentsRepository.getStudentsArray());
                    break;
                case 8:
                    System.out.println("Base Teachers:");
                    teachersService.printTeachersArray(teachersRepository.getTeachersArray());
                    break;
                case 10:
                    System.out.println("Enter lesson id");
                    int id = scanner.nextInt();
                    lesson.getById(id);
                    break;
                case 11:
                    System.out.println("Enter lesson id to delete");
                    int idDel = scanner.nextInt();
                    lessonsService.printLessonsArray(lesson.deleteById(idDel));
                    break;

                case 9:
                    System.out.println("Base Courses:");
                    coursesService.printCoursesArray(cr.getAll());
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
