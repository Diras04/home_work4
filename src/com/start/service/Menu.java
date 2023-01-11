package com.start.service;

import com.start.models.*;
import com.start.repository.*;
import java.util.Scanner;

public class Menu {
    LessonsService lessonsService = new LessonsService();
    StudentsService studentsService = new StudentsService();
    TeachersService teachersService = new TeachersService();
    CoursesService coursesService = new CoursesService();
    RepositoryService<Courses> cr = new RepositoryService<>(Courses.class);
    RepositoryService<Lessons> lesson = new RepositoryService<>(Lessons.class);
    RepositoryService<Person> teachersRepository = new
            RepositoryService<>(Person.class);
    RepositoryService<Person> studentsRepository = new RepositoryService<>(Person.class);
    RepositoryService<Homework> homeworkRepository = new RepositoryService<>(Homework.class);
    RepositoryService<AdditionalMaterials> additionalMaterialsRepository = new RepositoryService<>(AdditionalMaterials.class);
    AdditionalMaterialsService additionalMaterialsService = new AdditionalMaterialsService();


    public void mainMenu() {


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
            System.out.println("Show all AM - press 12 *** ");
            System.out.println("Show all AM by LessonId - press 13 *** ");
            System.out.println("Show all AM by type - press 14 *** ");
            System.out.println("Exit - prees 5");

            k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    createAll();

                    break;
                case 2:
                    teachersRepository.addObjectToArray(TeachersService.createTeachers());
                    break;
                case 3:
                    studentsRepository.addObjectToArray(StudentsService.createStudents());
                    break;
                case 4:

                    for (int i = 1; i <= 8; i++) {

                        System.out.println("Enter the title of the lecture, or enter stop to go main menu");
                        String name = scanner.nextLine();


                        if (name.equals("stop")) {

                            break;
                        }


                        System.out.println("Description");
                        String description = scanner.nextLine();
                        System.out.println("Enter the dopinfo");
                        String dopInfo = scanner.nextLine();

                        String firstName;
                        while (true) {
                            System.out.println("Enter teachers First name");
                            firstName = scanner.nextLine();
                            if (lessonsService.checkName(firstName)) {
                                break;
                            }

                            System.out.println("Enter First letter capital ");

                        }
                        String lastName;
                        while (true) {
                            System.out.println("Enter teachers Last name");
                            lastName = scanner.nextLine();
                            if (lessonsService.checkName(lastName)) {
                                break;
                            }

                            System.out.println("Enter First letter capital");
                        }
                        String phone;

                        while (true) {
                            System.out.println("Enter teachers phone");
                            phone = scanner.nextLine();

                            if (lessonsService.checkPhone(phone)) {
                                break;
                            }
                            System.out.println("Enter only numbers ");
                        }
                        String email;
                        while (true) {
                            System.out.println("Enter teachers Email");
                            email = scanner.nextLine();
                            if (lessonsService.checkEmail(email)) {
                                break;
                            }
                            System.out.println("Enter real email");
                        }

                        Person person = new Person(firstName, lastName, phone, email, Role.TEACHER);
                        int courseId = 0;

                        if (cr.getAll().size() > 0) {
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

                        Lessons L = new Lessons(name, homeworkRepository.getAll(), dopInfo, person, description);
                        L.setCourseId(courseId);

                        lesson.addObjectToArray(L);
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
                    studentsService.printStudentsArray(studentsRepository.getAll());
                    break;
                case 8:
                    System.out.println("Base Teachers:");
                    teachersService.printTeachersArray( teachersRepository.getAll());
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
                case 12:
                    additionalMaterialsService.printAmArray(additionalMaterialsRepository.getAll());

                    break;
                case 13:
                    additionalMaterialsService.printAmArrayByLessonId( additionalMaterialsRepository.getAll());

                    break;
                case 14:
                    additionalMaterialsService.printAmArrayByType( additionalMaterialsRepository.getAll());

                    break;

                default:
                    System.out.println("____________________Make the right choice!!!!!!");


            }
            if (Lessons.idstatik == 8) {
                break;
            }

        }


    }

    private void createAll() {
        homeworkRepository.addObjectToArray(HomeworkService.createHomework());
        Person firstTeacher = new Person("Elena", "Simonova", "7531446",
                "simonova@gmail.com", Role.TEACHER);

        Lessons firstLesson = new Lessons("Discrete mathematics", homeworkRepository.getAll(), "Page 26",
                firstTeacher, "learn it");

        Person firstStudent = new Person("Egor", "Bazaleev",
                "781543", "bazaleev@gmail.com", Role.STUDENT);

        Person secondStudent = new Person("Victor", "Slobodyanik",
                "781543", "slob@gmail.com", Role.STUDENT);


        cr.addObjectToArray(CoursesService.createCoursre(firstLesson, firstStudent, "Math"));
        Person secondTeacher = new Person("Svitlana", "Kovalchik",
                "7885219", "kovalchik@gmail.com", Role.TEACHER);
        Person thirdTeacher = new Person("Galina", "Smirnova", "71228563",
                "smirnova@gmail.com", Role.TEACHER);

        lesson.addObjectToArray(firstLesson);
        teachersRepository.addObjectToArray(firstTeacher);
        studentsRepository.addObjectToArray(firstStudent);
        studentsRepository.addObjectToArray(secondStudent);
        teachersRepository.addObjectToArray(secondTeacher);
        lesson.addObjectToArray(new Lessons("An.Geomertry", homeworkRepository.getAll(), "Page 29", secondTeacher, "Learn it"));

        Lessons thirdlesson = new Lessons("MathAn", homeworkRepository.getAll(), "Page 30",
                thirdTeacher, "Learn it");
        lesson.addObjectToArray(thirdlesson);
        cr.addObjectToArray(CoursesService.createCoursre(thirdlesson, secondStudent, "Geo"));
        coursesService.printCoursesArray(cr.getAll());
        AdditionalMaterials firstAm = new AdditionalMaterials("Geo", 1, ResourceType.URL, 1);
        AdditionalMaterials secondAm = new AdditionalMaterials("Math", 2, ResourceType.VIDEO, 2);
        AdditionalMaterials thirdAm = new AdditionalMaterials("English", 3, ResourceType.BOOK, 3);
        AdditionalMaterials fourthAm = new AdditionalMaterials("Programing", 1, ResourceType.URL, 4);
        AdditionalMaterials fiveAm = new AdditionalMaterials("Codding", 1, ResourceType.VIDEO, 5);
        additionalMaterialsRepository.addObjectToArray(firstAm);
        additionalMaterialsRepository.addObjectToArray(secondAm);
        additionalMaterialsRepository.addObjectToArray(thirdAm);
        additionalMaterialsRepository.addObjectToArray(fourthAm);
        additionalMaterialsRepository.addObjectToArray(fiveAm);


    }


}

