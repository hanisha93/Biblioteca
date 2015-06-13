package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public void start(View view,MenuController menuController ) {
        int option=1;
        while(option!=0) {
            view.printToConsole(Messages.MENU_LIST);
            view.printToConsole(Messages.CHOOSE_OPTION);
            option = view.readInput();
            menuController.handleRequest(option);
        }
    }
}
