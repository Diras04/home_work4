package com.start.service;

import com.start.models.Log;

import java.io.*;

public class LogService {
    public static void writeLog(Log log) {
        String string;
        string = "Time - " + log.getTime() + "; Level - " + log.getLevel() + "; Name - " + log.getName() +
                "; Message - " + log.getMessage() + "; Stacktrace - " + log.getStackTrace();
        try {
            File file = new File("Log.txt");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("File exist");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));

            writer.write(string);
            writer.write("\n");


            writer.flush();
            writer.close();


        } catch (IOException r) {
            System.out.println(r);

        }

    }

    public static void readLog() {
        try {


            BufferedReader reader = new BufferedReader(new FileReader("Log.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);


            }
            reader.close();
        } catch (IOException r) {
            System.out.println(r);

        }

    }


}
