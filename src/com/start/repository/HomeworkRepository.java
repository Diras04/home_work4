package com.start.repository;

import com.start.models.Homework;
import com.start.models.SuperObject;
import com.start.service.RepositoryService;

public class HomeworkRepository extends RepositoryService {
    static int size = 0;


    int lenght = 1;
    Homework[] HomeworkArray = new Homework[lenght];


    public void addHomeworkToArray(Homework homework) {


        if (size < HomeworkArray.length) {
            HomeworkArray[size] = homework;
        } else {
            addSizeArray();
            HomeworkArray[size] = homework;

        }
        size++;


    }


    private void addSizeArray() {
        Homework[] longHomeworkArray = new Homework[((HomeworkArray.length) * 3 / 2) + 1];
        System.arraycopy(HomeworkArray, 0, longHomeworkArray, 0, HomeworkArray.length);
        HomeworkArray = longHomeworkArray;


    }

    public Homework[] getHomeworkArray() {
        Homework[] homeworkArray1 = new Homework[size];
        System.arraycopy(HomeworkArray, 0, homeworkArray1, 0, size);
        return homeworkArray1;
    }

    @Override
    public Object[] getAll() {
        return new SuperObject[0];
    }


    @Override
    public void getById(int id) {

    }

    @Override
    public SuperObject[] deleteById(int id) {
        return new SuperObject[0];
    }
}
