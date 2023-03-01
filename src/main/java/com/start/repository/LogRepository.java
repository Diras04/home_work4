package com.start.repository;

import com.start.models.Log;
import com.start.models.LogEnum;
import com.start.util.LogService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class LogRepository {
    private static LogRepository instance;
    private List<Log> logArray;
    LogService logService = new LogService();

    private LogRepository() {
        this.logArray = new ArrayList<>();

    }

    public static LogRepository getInstance() {
        if (instance == null) {
            instance = new LogRepository();
        }
        return instance;
    }

    public void createLogWarErr(String name, LogEnum level, String message, LocalDateTime time,
                                String stackrace) {

        Log log = new Log(name, level, message, stackrace, time);
        logService.writeLog(log);
        logArray.add(log);
    }

    public void createLog(String name, LogEnum level, String message, LocalDateTime time) {
        Log log = new Log(name, level, message, time);
        logService.writeLog(log);
        logArray.add(log);
    }


}
