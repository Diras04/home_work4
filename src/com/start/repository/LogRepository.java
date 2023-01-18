package com.start.repository;

import com.start.models.Log;
import com.start.models.LogEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    private List<Log> logArray;

    public LogRepository() {
        this.logArray = new ArrayList<>();

    }
    public static Log createLogWarErr(String name, LogEnum level, String message, LocalDateTime time,
                                      String stackrace){
        return new Log(name,level,message,stackrace,time);
    }
    public static Log createLog(String name, LogEnum level, String message, LocalDateTime time){
        return new Log(name,level,message,time);
    }
    public void addLog(Log log){
        logArray.add(log);
    }
}
