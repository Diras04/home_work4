package com.start.util;

import com.start.models.Log;
import com.start.models.LogEnum;

import java.io.*;
import java.nio.file.*;


public class LogService {
    public static String init = "Level =OFF";
    public static final String logFile = "D:\\java\\Start\\OnlineSchool\\Log.txt";
    public static final String levelFile = "D:\\java\\Start\\OnlineSchool\\Level\\Level.txt";


    public static void writeLog(Log log) {
        String string;
        string = "Time - " + log.getTime() + "; Level - " + log.getLevel() + "; Name - " + log.getName() +
                "; Message - " + log.getMessage() + "; Stacktrace - " + log.getStackTrace();
        try {
            File file = new File(logFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (init.contains("DEBUG") && log.getLevel() == LogEnum.DEBUG) {
                onlyWrite(string);
            } else if (init.contains("INFO") && log.getLevel() != LogEnum.ERROR &&
                    log.getLevel() != LogEnum.WARNING) {
                onlyWrite(string);
            } else if (init.contains("WARNING") && log.getLevel() != LogEnum.ERROR) {
                onlyWrite(string);

            } else if (init.contains("ERROR"))
                onlyWrite(string);


        } catch (IOException r) {
            System.out.println(r);

        }

    }

    public void readLog(String string) {
        try {


            BufferedReader reader = new BufferedReader(new FileReader(string));
            String line;
            while ((line = reader.readLine()) != null) {
                init = line;

            }
            reader.close();
        } catch (IOException r) {
            System.out.println(r);

        }


    }

    public static void onlyWrite(String string) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(string);
            writer.write("\n");


            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void levelWriter(int i) {
        String[] log = new String[]{"DEBUG", "INFO", "WARNING", "ERROR"};

        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(levelFile),
                StandardOpenOption.TRUNCATE_EXISTING)) {
            bf.write("Level =" + log[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
