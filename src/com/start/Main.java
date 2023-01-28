package com.start;


import com.start.service.LevelService;
import com.start.service.LogService;
import com.start.service.Menu;


public class Main {
    public static boolean debugFlag;
    public static void main(String[] args) {
      debugFlag = true;

        Thread log = new Thread(new LevelService());
        log.start();
        Menu menu = new Menu();
       menu.mainMenu();


    }


}

