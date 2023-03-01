package com.start;


import com.start.service.Menu;
import com.start.util.LevelService;


public class Main {
    public static boolean debugFlag;

    public static void main(String[] args) {


        Thread log = new Thread(new LevelService());
        log.start();
        Menu menu = new Menu();
        menu.mainMenu();


    }


}

