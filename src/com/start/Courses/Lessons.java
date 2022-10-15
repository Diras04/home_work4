package com.start.Courses;

public class Lessons {
    static int count;
    private String name;
    private int id;
    private String homeWork;
    private String dopInfo;

    public Lessons(){
        count++;
    }
    public static void countOfClass(){

        System.out.println("ExplCls - " + count);
    }
}
