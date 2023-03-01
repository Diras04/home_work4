package com.start.service;

import com.start.models.AdditionalMaterials;
import com.start.models.Lessons;
import com.start.models.LogEnum;
import com.start.models.Person;
import com.start.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Character.*;


public class LessonsService<E> {
    public boolean checkName(String name) {
        for (int j = 1; j < name.toCharArray().length; j++) {
            if (isUpperCase(name.toCharArray()[0]) == false || isLowerCase(name.toCharArray()[j]) == false
                    || isLetter(name.toCharArray()[j]) == false) {
                var value = Thread.currentThread().getStackTrace();
                LogRepository.getInstance().createLogWarErr("LessonsService", LogEnum.WARNING, "checkName",
                        LocalDateTime.now(), Arrays.deepToString(value));

                return false;
            }
        }
        return true;
    }


    public boolean checkPhone(String phone) {
        for (int j = 0; j < phone.toCharArray().length; j++) {
            if (isDigit(phone.toCharArray()[j]) == false) {
                var value = Thread.currentThread().getStackTrace();
                LogRepository.getInstance().createLogWarErr("LessonsService", LogEnum.WARNING, "checkPhone",
                        LocalDateTime.now(), Arrays.deepToString(value));
                return false;
            }
        }
        return true;

    }

    public boolean checkEmail(String email) {
        return email.contains("@");


    }

    public boolean duplicateСheckEmail(String email, List<Person> personList) {
        return personList.stream().noneMatch(element -> element.getEmail().equals(email));

    }

    public int checkLessonsFromData(List<Lessons> lessons, Map<Integer, List<AdditionalMaterials>> map) {

        var data = lessons
                .stream()
                .map(p -> p.getCreationDate())
                .min(LocalDateTime::compareTo);

        List<Lessons> allOldTimeLes = lessons
                .stream()
                .filter(p -> p.getCreationDate()
                        .isEqual(data.get()))
                .collect(Collectors.toList());

        Optional<Integer> maxListSize = allOldTimeLes.stream()
                .map(p -> p.getId())
                .map(p -> map.get(p))
                .map(p -> p.size())
                .max(Comparator.naturalOrder());

        Optional<Integer> result = allOldTimeLes.stream()
                .map(p -> p.getId())
                .map(p -> map.get(p))
                .filter(p -> p.size() == maxListSize.get())
                .flatMap(s -> s.stream())
                .map(p -> p.getLessonId())
                .findFirst();


        return (int) result.get();
    }


    public void printLessonsArray(List<E> lessonsArray) {

        for (E n : lessonsArray) {


            System.out.println("Id - " + ((Lessons) n).getId() + "; Name - " + ((Lessons) n).getName() +
                    "; CourseId - " + ((Lessons) n).courseId + "; Dop info - " + ((Lessons) n).getDopInfo() +
                    "; Home Work - " + ((Lessons) n).getHomeWork() +
                    "; Teacher - " + ((Lessons) n).getPerson() + "; Lesson create - " + ((Lessons) n).getCreationDateToString() +
                    "; Lesson date - " + ((Lessons) n).getLectureDateToString());

        }

    }

}
