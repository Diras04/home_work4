package com.start.service;

import com.start.models.Log;
import com.start.models.LogEnum;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogService {


    public static void writeLog(Log log) {
        String string;
        string = "Time - " + log.getTime() + "; Level - " + log.getLevel() + "; Name - " + log.getName() +
                "; Message - " + log.getMessage() + "; Stacktrace - " + log.getStackTrace();
        try {
            File file = new File("Log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (readLog("Level.txt").contains("DEBUG") && log.getLevel() == LogEnum.DEBUG) {
                onlyWrite(string);
            } else if (readLog("Level.txt").contains("INFO") && log.getLevel() != LogEnum.ERROR &&
                    log.getLevel() != LogEnum.WARNING) {
                onlyWrite(string);
            } else if (readLog("Level.txt").contains("WARNING") && log.getLevel() != LogEnum.ERROR) {
                onlyWrite(string);

            } else if (readLog("Level.txt").contains("ERROR"))
                onlyWrite(string);


        } catch (IOException r) {
            System.out.println(r);

        }

    }

    public static String readLog(String string) {
        try {


            BufferedReader reader = new BufferedReader(new FileReader(string));
            String line;
            while ((line = reader.readLine()) != null) {
                return line;

            }
            reader.close();
        } catch (IOException r) {
            System.out.println(r);

        }

        return string;
    }

    public static void onlyWrite(String string) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));
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
        String fileName = "D:\\java\\Start\\OnlineSchool\\Level.txt";

        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileName),
                StandardOpenOption.TRUNCATE_EXISTING)) {
            bf.write("Level =" + log[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
