package com.start.service;

import java.util.Random;

public class MyThread implements Runnable {
    String studentName;
    String taskName;
    Result result;

    public MyThread(String studentName, String taskName, Result result) {
        this.studentName = studentName;
        this.taskName = taskName;
        this.result = result;
        this.result.studentName=studentName;
    }


    @Override
    public synchronized void run() {

        result.finalResult = new Random().nextInt(14 - 8 + 1) + 8;

        System.out.println(studentName+" Student" + "---take--- " + taskName);


    }


}
