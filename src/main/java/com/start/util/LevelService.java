package com.start.util;
import java.io.IOException;
import java.nio.file.*;

public class LevelService implements Runnable {
   public static final String levelDir = "D:\\java\\Start\\OnlineSchool\\Level";
    public static final String levelFile = "D:\\java\\Start\\OnlineSchool\\Level\\Level.txt";
LogService logService = new LogService();
    public void watchServ() throws InterruptedException, IOException {
        Path path = Paths.get(levelDir);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY); 


        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                logService.readLog(levelFile);
            }
            key.reset();
        }


    }

    @Override
    public void run() {
        try {
            watchServ();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
