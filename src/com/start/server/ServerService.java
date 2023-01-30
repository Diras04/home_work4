package com.start.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ServerService implements Runnable {
    List<String> blackIP;
    String blackIPAdress = "D:\\java\\Start\\OnlineSchool\\Black Id\\Black id.txt";

    public ServerService() {
        this.blackIP = new ArrayList<>();
        readId(blackIPAdress);
    }

    public void readId(String string) {

        try {


            BufferedReader reader = new BufferedReader(new FileReader(string));
            String line;

            while ((line = reader.readLine()) != null) {
                blackIP.add(line);

            }
            reader.close();
        } catch (IOException r) {
            System.out.println(r);

        }


    }

    public void watchServer() throws InterruptedException, IOException {
        Path path = Paths.get("D:\\java\\Start\\OnlineSchool\\Black Id");
        WatchService watchService = FileSystems.getDefault().newWatchService();


        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);


        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                readId(blackIPAdress);
            }
            key.reset();
        }
    }

    @Override
    public void run() {
        try {

            watchServer();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getBlackIP() {
        return blackIP;
    }
}
