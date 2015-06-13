package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view,MenuController menuController ) {
        int option=1;
        while(option!=0) {
            view.printToConsole(MENU_LIST);
            view.printToConsole(CHOOSE_OPTION);
            option = view.readInput();
            menuController.handleRequest(option);
        }
    }
}
