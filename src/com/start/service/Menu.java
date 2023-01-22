package com.start.service;

import com.start.Main;
import com.start.models.*;
import com.start.repository.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Menu {

    @FunctionalInterface
    public interface SwichCaseInterface {

        public void doSwichCase();

    }

    Scanner scanner = new Scanner(System.in);
    LessonsService lessonsService = new LessonsService();
    StudentsService studentsService = new StudentsService();
    TeachersService teachersService = new TeachersService();
    CoursesService coursesService = new CoursesService();
    RepositoryService<Courses> coursesRepository = new RepositoryService<>(Courses.class);
    RepositoryService<Lessons> lesson = new RepositoryService<>(Lessons.class);
    RepositoryService<Person> teachersRepository = new
            RepositoryService<>(Person.class);
    RepositoryService<Person> studentsRepository = new RepositoryService<>(Person.class);
    RepositoryServiceMapa<Homework> homeworkRepository = new RepositoryServiceMapa<>(Homework.class);
    RepositoryServiceMapa<AdditionalMaterials> additionalMaterialsRepository = new RepositoryServiceMapa<>(AdditionalMaterials.class);
    AdditionalMaterialsService additionalMaterialsService = new AdditionalMaterialsService();


    SwichCaseInterface one = () -> {
        createAll();
    };
    SwichCaseInterface two = () -> {
        teachersRepository.addObjectToArray(TeachersService.createTeachers());
    };
    SwichCaseInterface three = () -> {
        studentsRepository.addObjectToArray(StudentsService.createStudents());
    };
    SwichCaseInterface four = () -> {
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
            System.out.println("Enter the homewor");
            String homework = scanner.nextLine();

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

            if (coursesRepository.getAll().size() > 0) {
                while (true) {
                    System.out.println("All created Courses:");
                    coursesService.printCoursesArray(coursesRepository.getAll());

                    System.out.println("Enter the course ID");


                    courseId = scanner.nextInt();
                    scanner.nextLine();
                    if (coursesRepository.checkId(courseId)) {
                        break;
                    }
                    System.out.println("Current IDcourse does not exist. Please try again");

                }
            }
            Homework homeWorkFromTerminale = new Homework(homework);
            Lessons lessonFromTerminal = new Lessons(name, dopInfo, person, description);
            lessonFromTerminal.setCourseId(courseId);
            homeworkRepository.add(lessonFromTerminal.getId(), homeWorkFromTerminale);

            lesson.addObjectToArray(lessonFromTerminal);
            System.out.println("Lessons:");

            lessonsService.printLessonsArray(lesson.getAll());
            System.out.println("Count of Lessons - " + Lessons.idstatik);
        }
    };
    SwichCaseInterface five = () -> {
        System.out.println("Good Bay ");
    };
    SwichCaseInterface six = () -> {
        System.out.println("Base Lessons:");
        lessonsService.printLessonsArray(lesson.getAll());

    };
    SwichCaseInterface seven = () -> {
        System.out.println("Base Students:");
        studentsService.printStudentsArray(studentsRepository.getAll());

    };
    SwichCaseInterface eight = () -> {
        System.out.println("Base Teachers:");
        teachersService.printTeachersArray(teachersRepository.getAll());

    };
    SwichCaseInterface nine = () -> {
        System.out.println("Base Courses:");
        coursesService.printCoursesArray(coursesRepository.getAll());
    };
    SwichCaseInterface ten = () -> {

        System.out.println("Enter lesson id");
        int id = scanner.nextInt();
        scanner.nextLine();
        lesson.getById(id);
        System.out.println(additionalMaterialsRepository.getById(id));
        System.out.println(homeworkRepository.getById(id));

        System.out.println("Do you wont to modify the file? Y/N");

        String name = scanner.nextLine();
        if (name.equals("N"))
            six.doSwichCase();

        else {
            System.out.println("Make a choice:");
            System.out.println("Delete HomeWork press 1");
            System.out.println("Сhange HomeWork press 2");
            System.out.println("Delete AM press 3");
            System.out.println("Сhange AM press 4");
            int k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    homeworkRepository.deleteById(id);
                    break;
                case 2:
                    System.out.println("Enter new homework");
                    homeworkRepository.add(id, new Homework(scanner.nextLine()));
                    break;
                case 3:
                    additionalMaterialsRepository.deleteById(id);
                    break;
            }
        }
    };
    SwichCaseInterface eleven = () -> {
        System.out.println("Enter lesson id to delete");
        int idDel = scanner.nextInt();
        lessonsService.printLessonsArray(lesson.deleteById(idDel));
    };
    SwichCaseInterface twelve = () -> {
        additionalMaterialsService.printAmArray(additionalMaterialsRepository.getAll());
    };
    SwichCaseInterface thirteen = () -> {
        studentsTest();
    };
    Map<Integer, SwichCaseInterface> swichCaseMap = Map.ofEntries(
            Map.entry(1, one),
            Map.entry(2, two),
            Map.entry(3, three),
            Map.entry(4, four),
            Map.entry(5, five),
            Map.entry(6, six),
            Map.entry(7, seven),
            Map.entry(8, eight),
            Map.entry(9, nine),
            Map.entry(10, ten),
            Map.entry(11, eleven),
            Map.entry(12, twelve),
            Map.entry(13, thirteen)
    );


    public void mainMenu() {
        int k = 0;
        while (k != 5) {
            try {
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
                System.out.println("Students Test 13 *** ");
                System.out.println("Exit - prees 5");

                k = scanner.nextInt();
                scanner.nextLine();
                (swichCaseMap.get(k)).doSwichCase();
            } catch (NullPointerException r) {
                var value = Thread.currentThread().getStackTrace();
                LogRepository.getInstance().createLogWarErr("Menu", LogEnum.ERROR, "Menu",
                        LocalDateTime.now(), Arrays.deepToString(value));
                System.out.println("Make correct choice" + r);

            }

        }
    }

    private void createAll() {
        if (Main.debugFlag) {
            LogRepository.getInstance().createLog("Menu", LogEnum.DEBUG, "createAll", LocalDateTime.now());
        }
        Homework homeworkLesson1 = new Homework("DM page25");
        Homework homeworkLesson2 = new Homework("An.Geo page 26");
        Homework homeworkLesson3 = new Homework("Math.An page 40");

        homeworkRepository.add(1, homeworkLesson1);
        homeworkRepository.add(2, homeworkLesson2);
        homeworkRepository.add(3, homeworkLesson3);


        Person firstTeacher = new Person("Elena", "Simonova", "7531446",
                "simonova@gmail.com", Role.TEACHER);

        Lessons firstLesson = new Lessons("Discrete mathematics", "Page 26",
                firstTeacher, "learn it");

        Person firstStudent = new Person("First", "Student",
                "781543", "first@gmail.com", Role.STUDENT);

        Person secondStudent = new Person("Second", "Student",
                "781543", "second@gmail.com", Role.STUDENT);
        Person thirdStudent = new Person("Third", "Student",
                "781543", "third@gmail.com", Role.STUDENT);
        Person fourthStudent = new Person("Fourth", "Student",
                "781543", "fource@gmail.com", Role.STUDENT);
        Person fifthStudent = new Person("Fifth", "Student",
                "781543", "fifth@gmail.com", Role.STUDENT);
        Person sixthStudent = new Person("Sixth", "Student",
                "781543", "sixth@gmail.com", Role.STUDENT);
        Person seventhStudent = new Person("Seventh", "Student",
                "781543", "seventh@gmail.com", Role.STUDENT);
        Person eighthStudent = new Person("Eighth", "Student",
                "781543", "eighth@gmail.com", Role.STUDENT);
        Person ninthStudent = new Person("Ninth", "Student",
                "781543", "ninth@gmail.com", Role.STUDENT);
        Person tenthStudent = new Person("Tenth", "Student",
                "781543", "tenth@gmail.com", Role.STUDENT);


        coursesRepository.addObjectToArray(CoursesService.createCoursre(firstLesson, firstStudent, "Math"));
        Person secondTeacher = new Person("Svitlana", "Kovalchik",
                "7885219", "kovalchik@gmail.com", Role.TEACHER);
        Person thirdTeacher = new Person("Galina", "Smirnova", "71228563",
                "smirnova@gmail.com", Role.TEACHER);

        lesson.addObjectToArray(firstLesson);
        teachersRepository.addObjectToArray(firstTeacher);

        studentsRepository.addObjectToArray(firstStudent);
        studentsRepository.addObjectToArray(secondStudent);
        studentsRepository.addObjectToArray(thirdStudent);
        studentsRepository.addObjectToArray(fourthStudent);
        studentsRepository.addObjectToArray(fifthStudent);
        studentsRepository.addObjectToArray(sixthStudent);
        studentsRepository.addObjectToArray(seventhStudent);
        studentsRepository.addObjectToArray(eighthStudent);
        studentsRepository.addObjectToArray(ninthStudent);
        studentsRepository.addObjectToArray(tenthStudent);

        teachersRepository.addObjectToArray(secondTeacher);
        lesson.addObjectToArray(new Lessons("An.Geomertry", "Page 29", secondTeacher, "Learn it"));

        Lessons thirdlesson = new Lessons("MathAn", "Page 30",
                thirdTeacher, "Learn it");
        lesson.addObjectToArray(thirdlesson);
        coursesRepository.addObjectToArray(CoursesService.createCoursre(thirdlesson, secondStudent, "Geo"));
        coursesService.printCoursesArray(coursesRepository.getAll());
        AdditionalMaterials firstAm = new AdditionalMaterials("Geo", 1, ResourceType.URL, 1);
        AdditionalMaterials secondAm = new AdditionalMaterials("Math", 2, ResourceType.VIDEO, 2);
        AdditionalMaterials thirdAm = new AdditionalMaterials("English", 3, ResourceType.BOOK, 3);

        additionalMaterialsRepository.add(firstAm.getLessonId(), firstAm);
        additionalMaterialsRepository.add(secondAm.getLessonId(), secondAm);
        additionalMaterialsRepository.add(thirdAm.getLessonId(), thirdAm);

        homeworkRepository.add(homeworkLesson1.lessonId, homeworkLesson1);
        homeworkRepository.add(homeworkLesson2.lessonId, homeworkLesson2);
        homeworkRepository.add(homeworkLesson3.lessonId, homeworkLesson3);


    }

    public  void  studentsTest() {

        List<Thread> threadList = new ArrayList<Thread>();
        List<String> tasks = Arrays.asList("Task1", "Task2", "Task3", "Task4", "Task5", "Task6", "Task7", "Task8", "Task9", "Task10");
        Result[] results = new Result[10];
        for (int j = 0; j < results.length; j++) {
            results[j] = new Result();
        }

        for (int i = 0; i < studentsRepository.size(); i++) {
            threadList.add(new Thread(new MyThread(studentsRepository.getAll().get(i).getName(),
                    tasks.get(new Random().nextInt(9 - 0 + 1) + 0), results[i])));
            threadList.get(i).start();
        }
        List<Result> bestStudents = new ArrayList<>();
        System.out.println("Complete test:");
        for (Result n : results) {
            if (n.finalResult <= 12) {
                bestStudents.add(n);
            }
        }
        Collections.sort(bestStudents, Result.ResultComparator);
        for (Result n : bestStudents) {
            System.out.println("Student name - " + n.studentName + ", Result - " + n.finalResult);

        }
        System.out.println("Fail test:");
        for (Result n : results) {
            if (n.finalResult > 12) {
                System.out.println("Student name - " + n.studentName + ", Result - " + n.finalResult);
            }
        }


    }


}

