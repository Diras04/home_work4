package com.start.models;

import java.time.LocalDateTime;

public class Log {
    private String name;
    private LogEnum level;
    private String message;
    private String stackTrace;
    private LocalDateTime time;

    public Log(String name, LogEnum level, String message, String stackTrace, LocalDateTime time) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.stackTrace = stackTrace;
        this.time = time;

    }

    public Log(String name, LogEnum level, String message,LocalDateTime time ) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LogEnum getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
