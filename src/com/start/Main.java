package com.start;

import com.start.courses.Lessons;
import com.start.service.CoursesService;
import com.start.service.LessonsService;
import com.start.service.TeachersService;
import com.start.service.StudentsService;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayList<Lessons> lessonsArrayList = new ArrayList<>();


        LessonsService lectioin = new LessonsService(lessonsArrayList);
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (k != 5) {
            System.out.println("Select a category");
            System.out.println("Courses - press 1");
            System.out.println("Teacher - press 2");
            System.out.println("Students - press 3");
            System.out.println("Lessons create - press 4");
            System.out.println("Exit - prees 5");

            k = scanner.nextInt();
            scanner.nextLine();
            switch (k) {
                case 1:
                    System.out.println(CoursesService.createCourses());

                    break;
                case 2:
                    System.out.println(TeachersService.createTeachers());
                    break;
                case 3:
                    System.out.println(StudentsService.createStudents());
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

                        lectioin.addLessons(new Lessons(name, homeWork, dopInfo));
                        System.out.println(lectioin);
                        System.out.println("Count of Lessons - " + Lessons.idstatik);
                    }
                    break;


                case 5:
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


       /*ArrayList<Teachers> teachersarray = new ArrayList<>();
        ArrayList<Students> studentsarray = new ArrayList<>();
        ArrayList<Lessons> lessonsarray = new ArrayList<>();
        teachersarray.add(new Teachers("Belozerov"));
        teachersarray.add(new Teachers("Kovalchik F.B."));
        teachersarray.add(new Teachers("Makogon"));
        studentsarray.add(new Students("Derkach"));
        studentsarray.add(new Students("Goosarev"));
        studentsarray.add(new Students("Slobodjanik"));
        lessonsarray.add(new Lessons("Cryptography","Fermat's theorem","Learn matrix forms"));
        lessonsarray.add(new Lessons("Analytical geometry","Stewart's theorem","Very difficult"));
        lessonsarray.add(new Lessons("C++","Classes","Practice programming"));*/
    /*    {
            TeachersService first = new TeachersService(teachersarray);
        }
        StudentsService second = new StudentsService(studentsarray);
        LessonsService third = new LessonsService(lessonsarray);
        Courses fouth = new Courses("Math", third.getByName("C++"), second.getByName("Derkach"), first.getByName("Makogon"));
        third.getByName("C++").setCourseId(fouth.id);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);*/