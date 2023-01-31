package com.start;


import com.start.server.Client;
import com.start.server.Server;
import com.start.util.LevelService;


public class Main {
    public static boolean debugFlag;
    public static void main(String[] args) {



       Thread log = new Thread(new LevelService());
        log.start();
       /* Menu menu = new Menu();
       menu.mainMenu();*/
        Thread server = new Thread(new Server());
        Thread client = new Thread(new Client());

        server.start();
        client.start();


    }


}

