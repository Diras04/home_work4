package com.start.service;

import com.start.models.Person;

import java.util.Comparator;

public class Result {
    public int finalResult;
    public String studentName;

    public Result() {
        this.finalResult = 0;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public static Comparator<Result> ResultComparator = new Comparator<Result>() {

        public int compare(Result c1, Result c2) {
            int aMName1 = c1.getFinalResult();
            int amName2 = c2.getFinalResult();


            return aMName1 - amName2;


        }
    };
}
